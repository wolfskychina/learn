package leetcode.a1500;

import java.util.Arrays;

/**
 * 切棍子的最小成本
 * {dp},{hard}区间dp TODO
 */
public class _1547Solution {

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length + 2;
        int[] newCuts = new int[m];
        System.arraycopy(cuts, 0, newCuts, 1, m - 2);
        newCuts[m - 1] = n;

        int[][] f = new int[m][m];
        for (int i = m - 3; i >= 0; i--) {
            for (int j = i + 2; j < m; j++) {
                int res = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    res = Math.min(res, f[i][k] + f[k][j]);
                }
                f[i][j] = res + newCuts[j] - newCuts[i];
            }
        }
        return f[0][m - 1];
    }
}
