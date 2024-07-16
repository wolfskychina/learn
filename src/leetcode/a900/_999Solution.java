package leetcode.a900;

/**
 * 可以被车捕获的棋子数量
 * {easy}
 */
public class _999Solution {

    public int numRookCaptures(char[][] board) {

        int i = 0;
        int j = 0;
        boolean found = false;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {

                if (board[i][j] == 'R') {
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }
        int count = 0;
        int x = i + 1;
        int y = j;
        for (; x < board.length; x++) {
            if (board[x][y] == 'p') {
                count++;
                break;
            } else if (board[x][y] == 'B')
                break;

        }
        x = i - 1;
        y = j;
        for (; x >= 0; x--) {
            if (board[x][y] == 'p') {
                count++;
                break;
            } else if (board[x][y] == 'B')
                break;

        }
        y = j - 1;
        x = i;
        for (; y >= 0; y--) {
            if (board[x][y] == 'p') {
                count++;
                break;
            } else if (board[x][y] == 'B')
                break;

        }
        y = j + 1;
        x = i;
        for (; y < board[0].length; y++) {
            if (board[x][y] == 'p') {
                count++;
                break;
            } else if (board[x][y] == 'B')
                break;

        }

        return count;
    }

    public static void main(String[] args) {

        _999Solution so = new _999Solution();
        char[][] board = { { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', 'p', '.', '.', '.', '.' },
                { '.', '.', '.', 'R', '.', '.', '.', 'p' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', 'p', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' } };
        so.numRookCaptures(board);
    }
}
