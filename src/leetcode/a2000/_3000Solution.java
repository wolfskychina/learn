package leetcode.a2000;
/**
 * 对角线最长的矩形的面积的最大值
 */
public class _3000Solution {

    public int areaOfMaxDiagonal(int[][] dimensions) {

        int diagonal = 0;
        int maxarea = 0;

        for (int[] d : dimensions) {

            if (d[0] * d[0] + d[1] * d[1] > diagonal) {
                diagonal = d[0] * d[0] + d[1] * d[1];
                maxarea = d[0] * d[1];
            } else if (d[0] * d[0] + d[1] * d[1] == diagonal &&
                    d[0] * d[1] > maxarea) {
                maxarea = d[0] * d[1];
            }
        }

        return maxarea;
    }
}
