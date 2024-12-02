package leetcode.a3000;

/**
 * 统计X和Y频数相等的子矩阵
 * {prefix sum}
 */
public class _3212Solution {

    public int numberOfSubmatrices(char[][] grid) {

        int sum[][][] = new int[grid.length + 1][grid[0].length + 1][2];
        int count = 0;
        for (int i = 1; i < sum.length; i++) {

            for (int j = 1; j < sum[0].length; j++) {

                sum[i][j][0] = (grid[i - 1][j - 1] == 'X' ? 1
                        : 0) - sum[i - 1][j - 1][0] + sum[i - 1][j][0] + sum[i][j - 1][0];
                sum[i][j][1] = (grid[i - 1][j - 1] == 'Y' ? 1
                        : 0) - sum[i - 1][j - 1][1] + sum[i - 1][j][1] + sum[i][j - 1][1];
                if (sum[i][j][0] == sum[i][j][1] && sum[i][j][0] != 0)
                    count++;
            }
        }
        return count;
    }

    /**
     * 速度更快
     * 逐层相加，保留上一层的计算结果，下一层的矩形里面的数量可以通过
     * 遍历得出
     * @param grid
     * @return
     */
    public int numberOfSubmatrices1(char[][] grid) {
        int res = 0;
        int n = grid[0].length;
        int[][] memo = new int[n][2];
        for (char[] c : grid) {
            int[] prev = new int[2];
            for (int i = 0; i < n; i++) {
                if (c[i] != '.')
                    prev[c[i] & 1]++;
                memo[i][0] += prev[0];
                memo[i][1] += prev[1];
                if (memo[i][0] == memo[i][1] && memo[i][0] > 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        _3212Solution so = new _3212Solution();
        char[][] grid = { { 'X', 'X' }, { 'X', 'Y' } };
        so.numberOfSubmatrices(grid);
    }
}
