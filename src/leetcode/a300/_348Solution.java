package leetcode.a300;

/**
 * 348. Design Tic-Tac-Toe
 * 给定一系列步骤，判断最后谁赢
 */
public class _348Solution {

    char[][] cell;

    public _348Solution(int n) {
        cell = new char[n][n];
    }

    /**
     * 只需要判断该元素所在的行列和对角线
     * 
     * @param row
     * @param col
     * @param player
     * @return
     */
    public int move(int row, int col, int player) {

        char c = (player == 1) ? 'X' : '0';
        cell[row][col] = c;
        boolean r1 = true, r2 = true, r3 = true, r4 = true;
        for (int i = 0; i < cell.length; i++) {
            if (cell[row][i] != c)
                r1 = false;
            if (cell[i][col] != c)
                r2 = false;
            if ((row != col) || cell[i][i] != c)
                r3 = false;
            if ((row + col != cell.length - 1) || cell[i][cell.length - i - 1] != c)
                r4 = false;
        }

        if (r1 | r2 | r3 | r4) {

            return player;
        } else {

            return 0;
        }

    }

    /**
     * O(1)的解法
     * 只有某列或者某行或者对象线的和是n或者-n的时候，有人获胜
     */
    public class TicTacToe {
        int[] rows;
        int[] cols;
        int diagonal;
        int antiDiagonal;

        public TicTacToe(int n) {
            rows = new int[n];
            cols = new int[n];
        }

        public int move(int row, int col, int player) {
            int currentPlayer = (player == 1) ? 1 : -1;
            // 更新 rows 和 cols 数组中的当前用户
            rows[row] += currentPlayer;
            cols[col] += currentPlayer;
            // 更新 diagonal
            if (row == col) {
                diagonal += currentPlayer;
            }
            // 更新 antiDiagonal
            if (col == (cols.length - row - 1)) {
                antiDiagonal += currentPlayer;
            }
            int n = rows.length;
            // 检查玩家是否赢得游戏
            if (Math.abs(rows[row]) == n ||
                    Math.abs(cols[col]) == n ||
                    Math.abs(diagonal) == n ||
                    Math.abs(antiDiagonal) == n) {
                return player;
            }
            // 没有人赢
            return 0;
        }
    }

}
