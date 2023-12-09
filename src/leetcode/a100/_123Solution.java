package leetcode.a100;
/**
 * 买卖股票，最多允许买卖两次的情况下，能够获取的最大利润
 * 
 */
public class _123Solution {
   
    /**
     * {dp} ,表示四种状态下
     * 买入1次成本最小的状态
     * 卖出1次利润最大的状态
     * 买入2次成本最小的状态（需要考虑卖出一次利润）
     * 卖出2次利润最大的状态
     * 相邻的状态转移公式
     * 原则是买入的成本最小，卖出的利润最大
     * 最后卖出2次利润最大的状态就是最终结果
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = prices[0], sell1 = 0;
        int buy2 = prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, - buy1 + prices[i]);
            // 第一次卖掉产生的利润降低了总的成本
            buy2 = Math.min(buy2, - sell1 + prices[i]);
            sell2 = Math.max(sell2, -buy2 + prices[i]);
        }
        return sell2;
    }

    /**
     * 另一种统一考虑利润的思路，可以将四种状态所表达的含义统一
     * 将买入的成本计提为负的利润，从而使得每种状态都表示利润的最大值
     * 
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

}
