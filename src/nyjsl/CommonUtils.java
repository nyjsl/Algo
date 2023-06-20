package nyjsl;

import java.util.Collections;
import java.util.List;

public class CommonUtils {

    public static <T> void swap(T[] src, int i, int j) {
        T temp = src[i];
        src[i] = src[j];
        src[j] = temp;
    }
    public static void swap(char[] src, int i, int j) {
        char temp = src[i];
        src[i] = src[j];
        src[j] = temp;
    }

    public static <T> void printList(List<T> src) {
        for (T t : src) {
            System.out.print(t.toString()+",");
        }
    }

}


