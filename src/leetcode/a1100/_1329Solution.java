package leetcode.a1100;

import java.util.Arrays;
/**
 * 将矩阵按照逐对角线排序
 * {matrix},{sorting}
 */
public class _1329Solution {

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] a = new int[Math.min(m, n)];
        for (int k = 1 - n; k < m; k++) { // k = i - j
            // Math.max 和 Math.min 限制了对角线上的左右范围在矩形的范围内
            // max(0) 和min(m) 把对角线在矩形范围外的部分切掉
            int leftI = Math.max(k, 0);
            int rightI = Math.min(k + n, m);
            for (int i = leftI; i < rightI; i++) {
                a[i - leftI] = mat[i][i - k];
            }
            Arrays.sort(a, 0, rightI - leftI);
            for (int i = leftI; i < rightI; i++) {
                mat[i][i - k] = a[i - leftI];
            }
        }
        return mat;
    }
}
