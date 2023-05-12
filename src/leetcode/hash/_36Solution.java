package leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 校验一个初始化的数独是否是合法的
 * 一个数独是合法的不代表一定有解
 */
public class _36Solution {

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<String>();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }

}