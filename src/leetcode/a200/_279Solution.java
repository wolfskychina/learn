package leetcode.a200;
/**
 * 和相加等于n的最少的平方数的组合
 * {dp}
 */
public class _279Solution {

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
    
}
