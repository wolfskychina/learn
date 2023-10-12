package leetcode.a400;

import java.util.List;

/**
 * 422. Valid Word Square
 * 判断一个字符矩阵，每行和对应列的字符组成是否完全一致 
 */
public class _422Solution {

    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        char[][] cs = new char[n][];
        for (int i = 0; i < n; i++) {
            cs[i] = words.get(i).toCharArray();
        }

        for (int i = 0; i < n; i++) {
            if (!Check(cs, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean Check(char[][] cs, int i) {
        if (cs[i].length > cs.length) {
            return false;
        }
        int k = 0;
        for (; k < cs[i].length; k++) {
            if (cs[k].length <= i || cs[k][i] != cs[i][k]) {
                return false;
            }
        }

        for (; k < cs.length; k++) {
            if (cs[k].length > i) {
                return false;
            }
        }
        return true;
    }

}
