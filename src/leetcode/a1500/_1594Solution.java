package leetcode.a1500;

/**
 * 矩阵从左上角到右下角的最大非负积
 * {dp}比较基础的矩阵dp但是稍微繁琐
 * 注意题目要求是最后再取余
 */
public class _1594Solution {

    public int maxProductPath(int[][] grid) {
        int MOD = (int) 1e9 + 7;
        long[][] res = new long[grid[0].length][2];
        res[0][0] = grid[0][0];
        res[0][1] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            long new0 = res[i - 1][0] * grid[0][i];
            long new1 = res[i - 1][1] * grid[0][i];
            res[i][0] = Math.min(new0, new1);
            res[i][1] = Math.max(new0, new1);
        }
        for (int i = 1; i < grid.length; i++) {

            long new1 = res[0][0] * grid[i][0];
            long new2 = res[0][1] * grid[i][0];
            res[0][0] = Math.min(new1, new2);
            res[0][1] = Math.max(new1, new2);
            for (int j = 1; j < grid[0].length; j++) {
                long n1 = res[j - 1][0] * grid[i][j];
                long n2 = res[j - 1][1] * grid[i][j];
                long n3 = res[j][0] * grid[i][j];
                long n4 = res[j][1] * grid[i][j];
                res[j][0] = Math.min(Math.min(n1, n2), Math.min(n3, n4));
                res[j][1] = Math.max(Math.max(n2, n3), Math.max(n1, n4));
            }
        }

        return res[res.length - 1][0] < 0 && res[res.length - 1][1] < 0 ? -1
                : (int) (Math.max(res[res.length - 1][0], res[res.length - 1][1]) % MOD);
    }
}
