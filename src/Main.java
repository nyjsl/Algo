import nyjsl.linkedlist.MLinkedList;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 0; i < 10; i++) {
            test(false);
            test(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private  static AtomicBoolean biging = new AtomicBoolean(false);
    private  static AtomicBoolean smalling = new AtomicBoolean(false);

    /**
     * 小题提交 CountDownLatch ,开启小题提交阻塞完毕后才能执行大题提交
     */
    private static CountDownLatch partialSubmitCountDownLatch;
    /**
     * 如果小题提交进行中则进行等待
     */
    private static void waitIfPartialSubmitting() {
        if (smalling.get() && null != partialSubmitCountDownLatch) {
            try {
                partialSubmitCountDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static synchronized void test(boolean big) {
        if (big) {
            if (biging.get()) {
                return;
            }
            biging.set(true);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    waitIfPartialSubmitting();
                    System.out.println("大题提交运行");
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("大题提交结束");
                    biging.set(false);
                    partialSubmitCountDownLatch = null;
                }
            }).start();
        }else{
            if (biging.get()) {
                return;
            }
            System.out.println("小题提交运行");
            smalling.set(true);
            partialSubmitCountDownLatch = new CountDownLatch(1);
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("小题提交结束");
            partialSubmitCountDownLatch.countDown();
            smalling.set(false);
        }
    }
}