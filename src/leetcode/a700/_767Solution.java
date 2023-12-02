package leetcode.a700;

import java.util.Arrays;
/**
 * 一个字符串，能否通过重新排列使得字符串中所有相同字符均不相邻
 */
public class _767Solution {

    String res = "";

    /**
     * 标准backtrace方法搜索所有合法的拼接字符串，超时
     * {backtrace}
     * 
     * @param s
     * @return
     */
    public String reorganizeString1(String s) {

        int str[] = new int[26];
        for (char c : s.toCharArray()) {

            str[c - 'a']++;
        }

        backtrace(str, new StringBuilder(), s.length());
        return res;
    }

    private boolean backtrace(int str[], StringBuilder sb, int len) {

        if (sb.length() == len) {
            res = sb.toString();
            return true;
        }

        for (int i = 0; i < str.length; i++) {

            if (str[i] > 0 && (sb.length() == 0 || sb.charAt(sb.length() - 1) - 'a' != i)) {
                sb.append((char) (i + 'a'));
                str[i]--;
                if (backtrace(str, sb, len)) {
                    return true;
                }
                str[i]++;
                sb.setLength(sb.length() - 1);

            }
        }

        return false;
    }

    /**
     * 观察规律，只要保证出现最多次数的数字的个数-1个组即可
     * 其余的数字只要不少于出现最多次数的数字的个数-1，就一定能够将所有相同数字隔开
     * {combination math}
     * @param s
     * @return
     */
    public String reorganizeString(String s) {
        char[] array = s.toCharArray();
        int[] pattern = new int[26];

        for (char c : array) {
            pattern[c - 'a']++;
        }
        int max = 0;
        int idx = 0;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] > max) {
                idx = i;
                max = pattern[i];
            }
        }

        if (max - 1 > array.length - max)
            return "";

        char tar = (char) ('a' + idx);
        Arrays.sort(array);

        StringBuilder sb[] = new StringBuilder[max];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }

        idx = 0;
        for (int i = 0; i < max; i++) {
            sb[i].append(tar);
        }

        while (idx < array.length) {

            for (int i = 0; i < max; i++) {

                while (idx < array.length && array[idx] == tar)
                    idx++;
                if (idx == array.length)
                    break;
                sb[i].append(array[idx]);
                idx++;
            }
        }

        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }

        return sb[0].toString();
    }

    public static void main(String[] args) {

        _767Solution so = new _767Solution();
        so.reorganizeString("baaba");
    }
}
