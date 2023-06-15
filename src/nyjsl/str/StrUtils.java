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

    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     *
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *
     * 示例:
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     *
     * @param src 原字符串
     * @param k 证书
     * @return
     */
    public static String reverse2K(String src, int k) {
        char[] charArray = src.toCharArray();
        for (int i = 0; i < charArray.length; i+= 2*k) {
            int low = i;
            int high = Math.min(charArray.length-1,i+k-1);
            while (low < high) {
                CommonUtils.swap(charArray,low,high);
                low++;
                high--;
            }
        }
        return new String(charArray);
    }

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * 示例 1： 输入：s = "We are happy."
     * 输出："We%20are%20happy
     * @param s 源字符串
     * @return 结果
     */
    public  static String replaceSpace(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        //扩充空间，空格数量2倍
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                str.append("  ");
            }
        }
        //若是没有空格直接返回
        if(str.length() == 0){
            return s;
        }
        //有空格情况 定义两个指针
        int left = s.length() - 1;//左指针：指向原始字符串最后一个位置
        s += str.toString();
        int right = s.length()-1;//右指针：指向扩展字符串的最后一个位置
        char[] chars = s.toCharArray();
        while(left>=0){
            if(chars[left] == ' '){
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }else{
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }

}
