package leetcode.a2000;

/**
 * 购买水果所需的最少金币数
 * 如果选择买第i个水果，那么可以免费获得之后的i个水果
 * 问所有水果都要获得所需要的最少金币数
 * {dp}
 */
public class _2944Solution {

    /**
     * 在遍历的时候，当前阶段的最优解不仅依赖于前一阶段
     * 还会对之后阶段的最优解构成影响
     * @param prices
     * @return
     */
    public int minimumCoins(int[] prices) {

        // 0表示免费获得当前水果的最小花销
        // 1表示购买当前水果所需要的最小花销
        int cost[][] = new int[prices.length][2];
        for (int i = 0; i < cost.length; i++)
            cost[i][0] = Integer.MAX_VALUE;
        cost[0][1] = prices[0];
        if (prices.length == 1)
            return cost[0][1];
        cost[1][0] = cost[0][1];
        for (int i = 1; i < cost.length; i++) {
            cost[i][1] = Math.min(cost[i - 1][0], cost[i - 1][1]) + prices[i];
            // 对未来阶段可能的影响
            for (int j = i + 1; j < Math.min(cost.length, 2 * i + 2); j++) {
                cost[j][0] = Math.min(cost[j][0], cost[i][1]);
            }
        }

        return Math.min(cost[cost.length - 1][0], cost[cost.length - 1][1]);
    }
}
