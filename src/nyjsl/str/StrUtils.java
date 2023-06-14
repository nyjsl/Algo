package nyjsl.str;

import nyjsl.CommonUtils;

public class StrUtils {
    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符
     * @param src 源字符串
     * @return 翻转后的字符串
     */
    public static char[] reverse(char[] src) {
        if (null != src) {
            int length = src.length;
            int low = 0;
            int high = length-1;
            while (low < high) {
                CommonUtils.swap(src,low,high);
                low++;
                high--;
            }
        }
        return src;
    }
}
