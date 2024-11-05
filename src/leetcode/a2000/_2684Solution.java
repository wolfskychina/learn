package leetcode.a2000;

/**
 * 从矩阵的最左栏向右移动，每次能够移动到相邻栏的上中下三个格子，如果右侧相应格子数值更大的话
 * 问最多能移动多少个格子
 * {dp}
 */
public class _2684Solution {

    /**
     * 关键是如果某个格子无法到达一定要标记，避免下一层继续选择
     * @param grid
     * @return
     */
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] canMove = new boolean[m][n]; // canMove[i][j]表示是否可以移到到这个单元格
        int maxMove = 0; // 最大移动次数
        // 枚举每一列，再枚举每一行
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                // 枚举三种转移位置
                for (int p = -1; p <= 1; p++) {
                    if (i + p < 0 || i + p >= m)
                        continue; // 剔除非法状态
                    // 可移动需满足两个条件：1.这个单元格大于前一列的单元格；2.前一列的单元格可转移（首列一定可转移，即j==1时不需要看canMove[j-1]）
                    // 一旦满足可转移，即退出判断，并标记最大移动次数就是这个列索引
                    if (grid[i][j] > grid[i + p][j - 1] && (j == 1 || canMove[i + p][j - 1])) {
                        canMove[i][j] = true;
                        maxMove = j;
                        break;
                    }
                }
            }
        }
        return maxMove;
    }
}
