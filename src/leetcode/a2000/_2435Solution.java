package leetcode.a2000;

/**
 * 矩阵中和能被k整除的路径
 * 记录余数为0-k-1的所有情况
 * {dp}
 */
public class _2435Solution {

    /**
     * TODO 这个比较巧妙的是在矩阵的左侧和上侧加一个虚拟的行和列，
     * 不用单独处理第一行第一列
     * 
     * @param grid
     * @param k
     * @return
     */
    public int numberOfPaths(int[][] grid, int k) {
        final var mod = (int) 1e9 + 7;
        int m = grid.length, n = grid[0].length;
        var f = new int[m + 1][n + 1][k];
        f[0][1][0] = 1;
        for (var i = 0; i < m; ++i)
            for (var j = 0; j < n; ++j)
                for (var v = 0; v < k; ++v)
                    f[i + 1][j + 1][(v + grid[i][j]) % k] = (f[i + 1][j][v] + f[i][j + 1][v]) % mod;
        return f[m][n][0];
    }
}
