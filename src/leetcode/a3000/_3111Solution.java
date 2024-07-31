package leetcode.a3000;

import java.util.Arrays;

/**
 * 覆盖所有点的最少矩形数量
 * 矩形的高度没有限制，但是宽度最多为w
 * {sorting},{greedy}
 */
public class _3111Solution {
   
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (p, q) -> p[0] - q[0]);
        int ans = 0;
        int x2 = -1;
        for (int[] p : points) {
            if (p[0] > x2) {
                ans++;
                x2 = p[0] + w;
            }
        }
        return ans;
    }

}
