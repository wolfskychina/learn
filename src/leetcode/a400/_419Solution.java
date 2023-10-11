package leetcode.a400;
/**
 * 419. Battleships in a Board
 * ship之间是不相连的
 * 
 */
public class _419Solution {

    /**
     * 因为不同的船是不相连的，所以只要横向不挨着且和上面的格子不是船
     * 就是一条新船
     * 
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {

        int res = 0;
        for (int i = 0; i < board.length; i++) {
            int j = 0;

            while (j < board[0].length) {

                // the i-th line
                if ((i == 0 || board[i - 1][j] == '.')
                        && board[i][j] == 'X') {
                    // find a new ship
                    res++;
                    while (j < board[0].length && board[i][j] == 'X')
                        j++;

                } else {
                    j++;
                }

            }

        }

        return res;
    }
}
