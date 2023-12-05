package leetcode.a700;
/**
 * 判断一个井字棋的棋盘是不是可能出现的合法的棋盘
 */
public class _794Solution {

    /**
     * 需要考虑到所有的情况比较复杂
     * xxx   xox
     * xoo   oxo
     * xoo   xox   这几种情况都是可以成立的
     * @param board
     * @return
     */
    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                xCount = (c == 'X') ? (xCount + 1) : xCount;
                oCount = (c == 'O') ? (oCount + 1) : oCount;
            }
        }
        return !((oCount != xCount && oCount != xCount - 1) ||
               (oCount != xCount - 1 && win(board, 'X')) ||
               (oCount != xCount && win(board, 'O')));
    }

    public boolean win(String[] board, char p) {
        for (int i = 0; i < 3; ++i) {
            if ((p == board[0].charAt(i) && p == board[1].charAt(i) && p == board[2].charAt(i)) ||
               (p == board[i].charAt(0) && p == board[i].charAt(1) && p == board[i].charAt(2))) {
                return true;
            }
        }
        return ((p == board[0].charAt(0) && p == board[1].charAt(1) && p == board[2].charAt(2)) ||
                (p == board[0].charAt(2) && p == board[1].charAt(1) && p == board[2].charAt(0)));
    }

    public static void main(String[] args) {

        _794Solution so = new _794Solution();
        String[] board = {"XOX","OXO","XOX" };
        so.validTicTacToe(board);
    }
}
