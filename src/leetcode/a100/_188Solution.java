package leetcode.a100;

/**
 * 买卖股票的最大利润
 * 要求买卖不超过k次
 */
public class _188Solution {

    /**
     * 对买卖不超过2次的版本的扩充
     * {dp}
     * 
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int buy[] = new int[k];
        int sell[] = new int[k];
        for (int i = 0; i < buy.length; i++) {
            buy[i] = -prices[0];
        }
        for (int i = 1; i < n; ++i) {

            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k - 1];

    }

    /**
     * 进一步修改，使dp数组从1开始，统一状态转换的表达式
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit1(int k, int[] prices) {

        int n = prices.length;
        int buy[] = new int[k + 1];
        int sell[] = new int[k + 1];
        for (int i = 0; i < buy.length; i++) {
            buy[i] = -prices[0];
        }
        for (int i = 1; i < n; ++i) {

            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k];
    }
}
