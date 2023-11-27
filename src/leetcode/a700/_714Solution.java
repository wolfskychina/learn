package leetcode.a700;

/**
 * 最佳股票买卖时机
 * 每笔交易需要固定的手续费
 * 
 */
public class _714Solution {

    /*
     * {dp},开始想象的复杂了，卖出的时候需要跟所有可能买入时机去作差
     * 其实在买入的时候可以计提成本，这样卖出的时候就不用管什么时候买入的
     * 因为dp[i-1][1]中买入的成本已经在之前买入的时候计提
     * {TODO}
     */
    public int maxProfit(int[] prices, int fee) {
        // dp[i][0] 表示i天结束后没有持仓状态下的最大收益
        // dp[i][1] 表示i天结束后有持仓状态下的最大收益
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 由于只和上一步有关，所以可以改进为一维数组
     */
    public int maxProfit1(int[] prices, int fee) {
        // dp[i][0] 表示i天结束后没有持仓状态下的最大收益
        // dp[i][1] 表示i天结束后有持仓状态下的最大收益
        int n = prices.length;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }
        return dp[0];
    }

}
