package leetcode.a800;
/**
 * 任选三个点围成的最大三角形面积
 */
public class _812Solution {
   
    /**
     * 将三角形的面积转换为三个点投影到x坐标轴的三个梯形的面积之和
     * @param points
     * @return
     */
    public double largestTriangleArea(int[][] points) {
        int N = points.length;
        double res = 0;
        for (int i = 0; i < N - 2; i ++) {
            for (int j = i + 1; j < N - 1; j ++) {
                for (int k = j + 1; k < N; k ++) {
                    int[] point1 = points[i];
                    int[] point2 = points[j];
                    int[] point3 = points[k];
                    int x1 = point1[0], y1 = point1[1];
                    int x2 = point2[0], y2 = point2[1];
                    int x3 = point3[0], y3 = point3[1];
                    res = Math.max(res, 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));
                }
            }
        }
        return res;
    }
}
