package leetcode.a1600;

import java.util.Arrays;

/**
 * 具有给定数值的最小字符串
 * {easy}
 */
public class _1663Solution {

    public String getSmallestString(int n, int k) {
        char[] s = new char[n];
        Arrays.fill(s, 'a');
        int i = s.length - 1;
        int m = (k - n) / 25;
        int j = (k - n) % 25;
        while (m > 0) {
            s[i--] = 'z';
            m--;
        }
        if (i >= 0) {
            s[i] += j;
        }

        return new String(s);
    }
}
