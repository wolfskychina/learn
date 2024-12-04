package leetcode.a1800;

/**
 * 矩阵中的最大幻方
 * 幻方是指行列和对角线元素之和均相等的正方形
 * {prefix sum}
 */
public class _1895Solution {

    int[][] rowPre;
    int[][] colPre;
    int[][] diagPre;
    int[][] antiDiagPre;

    public int largestMagicSquare(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        rowPre = new int[row + 1][col + 1];
        colPre = new int[row + 1][col + 1];
        diagPre = new int[row + 1][col + 1];
        antiDiagPre = new int[row + 1][col + 1];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rowPre[i + 1][j + 1] = rowPre[i + 1][j] + grid[i][j];
                colPre[i + 1][j + 1] = colPre[i][j + 1] + grid[i][j];
                diagPre[i + 1][j + 1] = diagPre[i][j] + grid[i][j];
                // TODO 反对角线的前缀和计算
                // 反对角线的递推比较难理解，由于是先遍历上面的行，所以因为上一行遍历完了
                // 下一行的和依赖上一行已经计算过的结果
                // 所以j即使往小的方向遍历也不影响前缀和的计算
                antiDiagPre[i + 1][j] = antiDiagPre[i][j+1] + grid[i][j];
            }
        }

        for (int k = Math.min(row, col); k >= 1; k--) {
            for (int i = 0; i <= row - k; i++) {
                for (int j = 0; j <= col - k; j++) {
                    if (check(i, j, k)) {
                        return k;
                    }
                }
            }
        }
        return 1;
    }

    boolean check(int i, int j, int k) {
        int sum = rowPre[i + 1][j + k] - rowPre[i + 1][j];
        for (int x = i; x < i + k; x++) {
            if (rowPre[x + 1][j + k] - rowPre[x + 1][j] != sum)
                return false;
        }
        for (int y = j; y < j + k; y++) {
            if (colPre[i + k][y + 1] - colPre[i][y + 1] != sum)
                return false;
        }
        if (diagPre[i + k][j + k] - diagPre[i][j] != sum)
            return false;
        if (antiDiagPre[i + k][j] - antiDiagPre[i][j + k] != sum)
            return false;
        return true;
    }
}
