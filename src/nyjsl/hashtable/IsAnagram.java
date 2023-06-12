package nyjsl.hashtable;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 * 示例 2: 输入: s = "rat", t = "car" 输出: false
 * 说明: 你可以假设字符串只包含小写字母
 */
public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
        int[] table = new int[26];
        char[] aS = s.toCharArray();
        for (char a : aS) {
            table[a - 'a'] ++;
        }
        char[] aT = t.toCharArray();
        for (char c : aT) {
            table[c - 'a'] --;
        }
        for (int i : table) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
