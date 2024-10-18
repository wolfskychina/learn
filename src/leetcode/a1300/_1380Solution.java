package leetcode.a1300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 矩阵中的幸运数
 * {easy}
 */
public class _1380Solution {

    public List<Integer> luckyNumbers(int[][] matrix) {

        Set<Integer> minr = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            minr.add(min);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            if (minr.contains(max)) {
                list.add(max);
            }
        }
        return list;

    }
}
