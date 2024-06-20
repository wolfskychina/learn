package leetcode.a500;
/**
 * 不同面额的硬币，假设每种硬币的数量无限
 * 求对于一个数额，一共有多少种不同的组合方案
 * {package},{dp}
 */
public class _518Solution {

    int count = 0;

    /**
     * 开始用的回溯的方式凑方案，但是非常慢
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {

        dfs(amount, coins, 0);
        return count;

    }

    private void dfs(int remain, int[] coins, int idx) {

        if (idx == coins.length)
            return;
        int times = remain / (coins[idx]);
        for (int i = 0; i <= times; i++) {
            int newRemain = remain - i * coins[idx];

            if (newRemain == 0) {
                count++;
                break;
            } else if (newRemain < 0) {
                break;
            } else {
                dfs(remain - i * coins[idx], coins, idx + 1);
            }

        }
    }

    /**
     * dp解法，定义dp[i]为和为i的不同方案数
     * dp[i] 只能从dp[i-coin[k]]中得到
     * @param amount
     * @param coins
     * @return
     */
    public int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }


    public static void main(String[] args){

        _518Solution so = new _518Solution();
        int[] array = {3,5,7,8,9,10,11};
        so.change(500, array);
    }
}
