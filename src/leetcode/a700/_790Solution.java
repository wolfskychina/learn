package leetcode.a700;

/**
 * 两行N列的多米诺骨牌的拼装方式
 * 一共有两种骨牌
 */
public class _790Solution {

    int MOD = (int) 1e9 + 7;

    /**
     * {dp} i列一共有四种状态
     * 
     * @param n
     * @return
     */
    public int numTilings(int n) {
        int[][] f = new int[2][4];
        f[1][0] = f[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            int a = i & 1, b = (i - 1) & 1;
            f[a][0] = f[b][1];
            int cur = 0;
            for (int j = 0; j < 4; j++)
                cur = (cur + f[b][j]) % MOD;
            f[a][1] = cur;
            f[a][2] = (f[b][0] + f[b][3]) % MOD;
            f[a][3] = (f[b][0] + f[b][2]) % MOD;
        }
        return f[n & 1][1];
    }
}
