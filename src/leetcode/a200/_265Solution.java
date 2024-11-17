package leetcode.a200;

/**
 * 和256类似，粉刷n个房子，不同的是有k种颜色
 * 要求有onk的时间复杂度
 * 
 */
public class _265Solution {

    /**
     * {dp}
     * 仍然是dp，只是记一下上一轮dp的最小值是哪种颜色，这一轮该种颜色不能选相同的
     * 需要选次小的
     * @param costs
     * @return
     */
    public int minCostII(int[][] costs) {

        int[] dp = new int[costs[0].length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = costs[0][i];
        }
        for (int i = 1; i < costs.length; i++) {

            int[] tmp = new int[dp.length];
            int min = Integer.MAX_VALUE;
            int minidx = 0;
            int min2 = Integer.MAX_VALUE;
            int min2idx = 0;
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] < min) {
                    min2 = min;
                    min2idx = minidx;
                    min = dp[j];
                    minidx = j;
                } else if (dp[j] < min2) {
                    min2 = dp[j];
                    min2idx = j;
                }
            }
            for (int j = 0; j < dp.length; j++) {

                if (j == minidx) {
                    tmp[j] = dp[min2idx] + costs[i][j];
                } else {
                    tmp[j] = dp[minidx] + costs[i][j];
                }
            }
            for (int j = 0; j < dp.length; j++) {
                dp[j] = tmp[j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < dp.length; j++) {
            res = Math.min(res, dp[j]);
        }
        return res;
    }
}
