package leetcode.a800;
/**
 * 分汤,一共有4中不同的分法，每种分法等概率
 * 求A先分完的概率加上AB同时分完的概率的一半
 * {dp},{dfs}
 */
public class _808Solution {

    /**
     * 自底向上的dp
     * 会计算不可能走到的状态，比较慢
     * @param n
     * @return
     */
    public double soupServings1(int n) {
        if (n > 4450) {
            return 1;
        }

        n = (int) Math.ceil(n / 25d);

        double[][] dp = new double[n + 1][n + 1];

        dp[0][0] = 0.5;

        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = 0.25 * (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)]
                        + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]);
            }
        }

        return dp[n][n];
    }

    /**
     * 自顶向下的dp
     * 能走到的都是可能真实发生的状态
     * 
     * @param n
     * @return
     */
    public double soupServings(int n) {
        if (n > 4450) {
            return 1;
        }

        n = (int) Math.ceil(n / 25d);

        double[][] dp = new double[n + 1][n + 1];

        dp[n][n] = 1;

        double temp;

        for (int i = n; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                if (dp[i][j] == 0) {
                    continue;
                }

                temp = 0.25 * dp[i][j];

                dp[Math.max(0, i - 4)][j] += temp;
                dp[Math.max(0, i - 3)][Math.max(0, j - 1)] += temp;
                dp[Math.max(0, i - 2)][Math.max(0, j - 2)] += temp;
                dp[Math.max(0, i - 1)][Math.max(0, j - 3)] += temp;
            }
        }

        dp[0][0] /= 2;

        for (int i = 1; i <= n; i++) {
            dp[0][0] += dp[0][i];
        }

        return dp[0][0];
    }

    static double[][] dp;

    /**
     * 记忆化dps，自顶向下
     * @param n
     * @return
     */
    public double soupServings2(int n) {
        if (n > 4450) {
            return 1;
        }

        n = (int) Math.ceil(n / 25d);

        dp = new double[n + 1][n + 1];

        return dfs(n, n);
    }

    public double dfs(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        } else if (a <= 0) {
            return 1;
        } else if (b <= 0) {
            return 0;
        }

        if (dp[a][b] == 0) {
            dp[a][b] = 0.25 * (dfs(a - 4, b) + dfs(a - 3, b - 1) + dfs(a - 2, b - 2) + dfs(a - 1, b - 3));
        }

        return dp[a][b];
    }
}
