package leetcode.a2000;

import java.util.Arrays;

/**
 * 根据第k列的大小顺序对所有数据进行排序
 * {index sorting}
 */
public class _2545Solution {

    public int[][] sortTheStudents(int[][] score, int k) {
        int m = score.length;
        int n = score[0].length;
        int res[][] = new int[m][n];

        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> score[b][k] - score[a][k]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = score[idx[i]][j];
            }
        }
        return res;
    }
}
