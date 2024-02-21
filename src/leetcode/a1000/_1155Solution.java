package leetcode.a1000;
/**
 * n个有k面的骰子，每个骰子每个面分别由1-k分，问同时掷这n个骰子，分数之和target
 * 的方案有多少种
 */
public class _1155Solution {
  
    int mod = (int)1e9+7;
    /**
     * {dp}, f[i][j]表示前i个骰子，组成的和是j的方案数量
     * @param n
     * @param m
     * @param t
     * @return
     */
    public int numRollsToTarget(int n, int m, int t) {
        int[][] f = new int[n + 1][t + 1];
        f[0][0] = 1;
        // 枚举物品组（每个骰子）
        for (int i = 1; i <= n; i++) {
            // 枚举背包容量（所掷得的总点数）
            for (int j = 0; j <= t; j++) {
                // 枚举决策（当前骰子所掷得的点数）
                for (int k = 1; k <= m; k++) {
                    if (j >= k) {
                        f[i][j] = (f[i][j] + f[i-1][j-k]) % mod;
                    }
                }
            }
        } 
        return f[n][t];
    }

    /**
     * 
     * @param n
     * @param k
     * @param target
     * @return
     */
    public int numRollsToTarget1(int n, int k, int target) {
        if (target < n || target > n * k) {
            return 0; // 无法组成 target
        }
        final int MOD = 1_000_000_007;
        long[] f = new long[target - n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int mx = Math.min(i * (k - 1), target - n); // i 个骰子至多掷出 i*(k-1)
            for (int j = 1; j <= mx; j++) {
                f[j] += f[j - 1]; // 原地计算 f 的前缀和
            }
            for (int j = mx; j >= k; j--) {
                f[j] = (f[j] - f[j - k]) % MOD; // f[j] 是两个前缀和的差
            }
        }
        return (int) f[target - n];
    }
}
