package leetcode.a300;

/**
 * 343. Integer Break
 */
public class _343Solution {

    /**
     * 动态规划，一个整数不断分拆，任意一步都可以停止分拆
     * 规模不断变小
     * 
     * @param n
     * @return
     */
    public int integerBreak1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    /**
     * 基于数学理论，3尽可能最多，最多允许两个2
     * 
     * @param n
     * @return
     */
    public int integerBreak(int n) {

        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }

    }
}
