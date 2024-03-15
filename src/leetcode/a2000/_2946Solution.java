package leetcode.a2000;
/**
 * 循环移位后的矩阵相似检查
 * {easy}
 */
public class _2946Solution {
   
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
        k %= n;
        if (k == 0) {
            return true;
        }
        for (int[] r : mat) {
            for (int j = 0; j < n; j++) {
                if (r[j] != r[(j + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
}
