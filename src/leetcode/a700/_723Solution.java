package leetcode.a700;

import java.util.HashSet;
import java.util.Set;
/**
 * 简单版的消消乐
 * 每一回合结束同时消除所有可以消除的连续方块，然后再按照中立掉落
 */
public class _723Solution {

        /**
         * 非常巧妙，在两个方向，三个三个的判断, 如果是三个连续的相同数就变成负数
         * TODO
         * @param board
         * @return
         */
        public int[][] candyCrush1(int[][] board) {
            int R = board.length, C = board[0].length;
            boolean todo = false;
            for (int r = 0; r < R; ++r) {
                for (int c = 0; c + 2 < C; ++c) {
                    int v = Math.abs(board[r][c]);
                    if (v != 0 && v == Math.abs(board[r][c+1]) && v == Math.abs(board[r][c+2])) {
                        board[r][c] = board[r][c+1] = board[r][c+2] = -v;
                        todo = true;
                    }
                }
            }
            for (int r = 0; r + 2 < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    int v = Math.abs(board[r][c]);
                    if (v != 0 && v == Math.abs(board[r+1][c]) && v == Math.abs(board[r+2][c])) {
                        board[r][c] = board[r+1][c] = board[r+2][c] = -v;
                        todo = true;
                    }
                }
            }
   
            // 逐列处理新形成的-值
            for (int c = 0; c < C; ++c) {
                int wr = R - 1;
                for (int r = R-1; r >= 0; --r)
                    // 正值是需要保留的
                    if (board[r][c] > 0)
                        board[wr--][c] = board[r][c];
                while (wr >= 0)
                    board[wr--][c] = 0;
            }
    
            return todo ? candyCrush(board) : board;
        }

    private static int[][] step = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    /**
     * 有效糖果的认定，必须是横着或者竖着方向不小于3个，有重叠的也算
     * @param board
     * @return
     */
    public int[][] candyCrush(int[][] board) {
        boolean foundcandy = false;
        while (true) {

            foundcandy = markcandy(board);
            dealcandy(board);

            if (!foundcandy)
                break;
        }

        return board;
    }

    private void dealcandy(int[][] board) {
        // 冒泡，将底部的所有的0冒到上面
        for (int i = 0; i < board[0].length; i++) {
            int j = board.length-1;
            int k = board.length-1;
            while (j >= 0) {
                if (board[j][i] != 0)
                    board[k--][i] = board[j][i];
                j--;
            }
            while(k>=0){
                board[k--][i] =0;
            }
        }
    }

    private boolean markcandy(int[][] board) {
        boolean foundcandy = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == 0)
                    continue;
                int oriNum = board[i][j];
                Set<int[]> tmpSet = new HashSet<>();
                tmpSet.add(new int[] { i, j });
                board[i][j] =0;
                for (int k = 0; k < 4; k++) {
                    found(tmpSet, oriNum, i + step[k][0], j + step[k][1], board);
                }
                if (tmpSet.size() < 3) {
                    // 不符合要求需要改回来
                    for (int[] p : tmpSet) {
                        board[p[0]][p[1]] = oriNum;
                    }
                } else {
                    foundcandy = true;

                }
            }
        }
        return foundcandy;
    }

    private void found(Set<int[]> tmpSet, int target, int i, int j, int[][] board) {

        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == target) {
            tmpSet.add(new int[] { i, j });
            board[i][j] = 0;
            for (int k = 0; k < 4; k++) {
                found(tmpSet, target, i + step[k][0], j + step[k][1], board);
            }
        }
    }

    public static void main(String[] args){
        _723Solution so = new _723Solution();
        int[][] board = {{1,3,5,5,2},{3,4,3,3,1},{3,2,4,5,2},{2,4,4,5,5},{1,4,4,1,1}};
        so.candyCrush(board);
    }

}
