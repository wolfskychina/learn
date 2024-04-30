package leetcode.a200;

/**
 * 细胞自动机的下一个状态
 */
public class _289Solution {

    int[][] move = { { -1, -1 }, { 0, -1 }, { 1, -1 }, { -1, 0 }, { 1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };

    /**
     * 使用特殊状态标记由0变1和由1变0，从而使得下面的计数准确
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                int nb = countNeighbor(board, i, j);

                if (board[i][j] == 0) {
                    if (nb == 3)
                        board[i][j] = 2;
                } else {
                    if (nb < 2 || nb > 3)
                        board[i][j] = -1;
                }

            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == 2) {
                    board[i][j] = 1;
                    continue;
                }

                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }

            }
        }

    }

    private int countNeighbor(int[][] board, int i, int j) {

        int count = 0;
        for (int[] ints : move) {

            int ii = i + ints[0];
            int jj = j + ints[1];
            if (ii < 0 || ii == board.length || jj < 0 || jj == board[0].length)
                continue;
            if (board[ii][jj] == 1 || board[ii][jj] == -1)
                count++;
        }

        return count;

    }
}
