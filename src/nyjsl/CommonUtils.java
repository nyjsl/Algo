package nyjsl;

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

}


