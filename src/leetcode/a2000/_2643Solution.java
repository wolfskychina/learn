package leetcode.a2000;
/**
 * 1最多的行
 * {easy}
 */
public class _2643Solution {

    public int[] rowAndMaximumOnes(int[][] mat) {

        int maxnum = 0;
        int idx = 0;

        for (int i = 0; i < mat.length; i++) {
            int tmp = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    tmp++;
                }
            }
            if (tmp > maxnum) {
                maxnum = tmp;
                idx = i;
            }
        }

        return new int[] { idx, maxnum };
    }
}
