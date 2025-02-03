package leetcode.a2000;

import java.util.Arrays;

/**
 * 运动员和训练员的最大匹配数量
 * 同455分发饼干问题
 * {greedy}
 */
public class _2410Solution {

    public int matchPlayersAndTrainers(int[] g, int[] s) {

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
