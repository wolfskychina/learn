package leetcode.a3000;

public class _3129Solution {

    /**
     * 定义 f[i][j][k] 表示用 i 个 0 和 j 个 1 构造稳定数组的方案数，其中第 i+j 个位置要填 k，其中 k 为 0 或 1。
     * 状态转移方程：
     * 
     * f[i][j][0]
     * f[i][j][1]
     * 
     * =f[i−1][j][0]+f[i−1][j][1]−f[i−limit−1][j][1]
     * =f[i][j−1][0]+f[i][j−1][1]−f[i][j−limit−1][0]
     * ​
     * 
     * 如果 i≤limit 则 f[i−limit−1][j][1] 视作 0，如果 j≤limit 则 f[i][j−limit−1][0] 视作 0。
     * 
     * 初始值：f[i][0][0]=f[0][j][1]=1，其中 1≤i≤min(limit,zero), 1≤j≤min(limit,one)。
     * 
     * {dp}
     * @param zero
     * @param one
     * @param limit
     * @return
     */
    public int numberOfStableArrays(int zero, int one, int limit) {
        final int MOD = 1_000_000_007;
        int[][][] f = new int[zero + 1][one + 1][2];
        for (int i = 1; i <= Math.min(limit, zero); i++) {
            f[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(limit, one); j++) {
            f[0][j][1] = 1;
        }
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // + MOD 保证答案非负
                f[i][j][0] = (int) (((long) f[i - 1][j][0] + f[i - 1][j][1]
                        + (i > limit ? MOD - f[i - limit - 1][j][1] : 0)) % MOD);
                f[i][j][1] = (int) (((long) f[i][j - 1][0] + f[i][j - 1][1]
                        + (j > limit ? MOD - f[i][j - limit - 1][0] : 0)) % MOD);
            }
        }
        return (f[zero][one][0] + f[zero][one][1]) % MOD;
    }
}
