package leetcode.a500;

/**
 * 模拟扫雷中点击一步的逻辑
 * {recursion}
 */
public class _529Solution {

    int step[][] = { { -1, -1 }, { 0, -1 }, { 1, -1 }, { -1, 0 }, { 1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };

    /**
     * 按照题目描述实现逻辑即可
     * 
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {

        int x = click[0];
        int y = click[1];

        char cur = board[x][y];
        if (cur == 'M') {

            board[x][y] = 'X';
            return board;
        }
        if (cur == 'E') {
            int num = adjRevealedMinesNum(board, x, y);
            if (num == 0) {
                board[x][y] = 'B';

                for (int i = 0; i < 8; i++) {
                    int xx = x + step[i][0];
                    int yy = y + step[i][1];
                    if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length && board[xx][yy] == 'E') {
                        int[] next = { xx, yy };
                        updateBoard(board, next);
                    }
                }
            } else {
                board[x][y] = (char) ('0' + num);
            }

        }
        return board;

    }

    private int adjRevealedMinesNum(char[][] board, int x, int y) {

        int count = 0;
        int xx, yy;
        for (int i = 0; i < 8; i++) {
            xx = x + step[i][0];
            yy = y + step[i][1];
            if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length && board[xx][yy] == 'M')
                count++;
        }
        return count;
    }
}
