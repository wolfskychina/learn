package leetcode.a2000;

import java.math.BigInteger;

/**
 * 直线坐标系上恰好移动k步从起始点到终止点的不同移动方案数目
 * 组合数学
 * {dp},{combination}
 */
public class _2400Solution {

    private static final int mod = (int) 1e9 + 7;

    // 预处理所有的组合数，要注意取 mod，否则会溢出
    // 动态规范方式计算组合数
    private static long[][] dp = new long[1001][1001];
    static {
        for (int i = 0; i <= 1000; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= 1000; i++)
            for (int j = 1; j <= i; j++)
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        // 设左走 x 步，右走 y 步，计算 x 和 y 的差值
        int diff = Math.abs(endPos - startPos);
        // 判断方程是否有整数解
        if ((diff + k) % 2 != 0)
            return 0;
        if (diff > k)
            return 0;
        // 向左走的步数可以设置为 (diff + k) / 2 或者 (diff - k) / 2
        int left = (diff + k) / 2;
        // C(k, left) 就是结果
        return (int) (dp[k][left] % mod);
    }

    private static final int MOD = 1000000007;

    public int numberOfWays1(int startPos, int endPos, int k) {
        int step = Math.abs(startPos - endPos);

        // 检查是否满足步数要求
        if ((k - step) % 2 != 0 || k < step) {
            return 0;
        }

        int n = k;
        int r = step + (k - step) / 2;

        return comb(n, r);
    }

    // 计算组合数C(n, r)
    // 直接使用大整数运算计算组合数
    private int comb(int n, int r) {
        if (r > n)
            return 0;

        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;

        for (int i = 0; i < r; i++) {
            numerator = numerator.multiply(BigInteger.valueOf(n - i));
            denominator = denominator.multiply(BigInteger.valueOf(i + 1));
        }

        return numerator.divide(denominator).mod(BigInteger.valueOf(MOD)).intValue();
    }
}
