package leetcode.a400;

import java.util.Arrays;
/**
 * 分发饼干问题
 * g是至少需要多大的饼干
 * s是各个饼干的大小
 * 求最多能给几个人分到需要的饼干
 */
public class _455Solution {

    /**
     * {greedy}
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length, n = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            while (j < n && g[i] > s[j]) {
                j++;
            }
            if (j < n) {
                count++;
            }
        }
        return count;

    }
}
