package leetcode.a2000;

import java.util.Arrays;

/**
 * 公平分发饼干
 * {dp},{bitmask}
 */
public class _2305Solution {

    /**
     * 动态规划,f[i][s] 表示前i个人对某种特定的分配情况s下的最公平值
     * 很难想到，一般会考虑将第i个饼干进行分配的情况下的最公平值
     * 但是这个解的思路是依次求解分配某些特定饼干给前i个人的最公平值
     * 对所有分配方案的解空间的遍历
     * 空间复杂度为k*2的n次方
     * 
     * @param cs
     * @param k
     * @return
     */
    public int distributeCookies(int[] cs, int k) {
        int n = cs.length, mask = 1 << n, INF = 0x3f3f3f3f;
        int[] g = new int[mask];
        for (int s = 0; s < mask; s++) {
            int t = 0;
            for (int i = 0; i < n; i++)
                t += ((s >> i) & 1) == 1 ? cs[i] : 0;
            g[s] = t;
        }
        int[][] f = new int[k + 10][mask];
        for (int i = 0; i <= k; i++)
            Arrays.fill(f[i], INF);
        f[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int s = 0; s < mask; s++) {
                // 遍历s的所有可能的子集
                for (int p = s; p != 0; p = (p - 1) & s) {
                    f[i][s] = Math.min(f[i][s], Math.max(f[i - 1][s - p], g[p]));
                }
            }
        }
        return f[k][mask - 1];
    }
}
