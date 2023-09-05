package leetcode.a400;
/**
 * 买卖股票
 * 股票卖出后下一工作日不能买入，叫做冷却期
 * TODO
 */
public class _309Solution {

    /**
     * dp问题，定义每一个交易日结束后的三种状态
     * 0:当日结束后有持仓
     * 1：当日结束后无持仓，且下一日为冷静期,说明当日卖出
     * 2：当日结束后无持仓，且下一日为非冷却期
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < n; ++i) {
            int newf0 = Math.max(f0, f2 - prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1, f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }

        return Math.max(f1, f2);
    }

}
