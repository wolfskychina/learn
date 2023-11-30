package leetcode.a700;
/**
 * 爬台阶，一次可以上一个格子或者两个格子
 * 从每个格子往上爬所耗费的代价是一定的
 * 问爬完整个格子所需要的最低代价
 */
public class _746Solution {

    /**
     * {dp}
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {

        int dp[] = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = Math.min(cost[0], cost[1]);
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[dp.length - 1];

    }
}
