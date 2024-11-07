package leetcode.a2000;

/**
 * 将一个数字n表示为一组不相同的正整数的x方和的方案数
 * {dp}01背包问题,1的x方+2的x方+。。。+maxNum的x方，每个数字选或者不选
 * 主要是建模转化的思想
 */
public class _2787Solution {

    static final int MODULO = 1000000007;

    /**
     * maxNum最大值为n的log x次方
     * @param n
     * @param x
     * @return
     */
    public int numberOfWays(int n, int x) {
        int maxNum = (int) Math.pow(n + 0.5, 1.0 / x);
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= maxNum; i++) {
            int power = (int) Math.pow(i, x);
            for (int j = n; j >= power; j--) {
                dp[j] = (dp[j] + dp[j - power]) % MODULO;
            }
        }
        return dp[n];
    }
}
