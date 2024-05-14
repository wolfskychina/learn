package leetcode.a300;

import java.util.Arrays;

/**
 * 硬币找零，给定一些面值种类的硬币，问能否组成一个数额
 * 如果能，返回需要最少的硬币数量，假设每种硬币数量是无限的
 * {dp}
 */
public class _322Solution {
   
    /**
     * dp问题
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
