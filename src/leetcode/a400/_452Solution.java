package leetcode.a400;

import java.util.Arrays;

public class _452Solution {

    /**
     * 435题的变种
     * TODO 需要注意两个数比较大小时候可能会溢出
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {

        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (o1, o2) -> (long) o1[1] - (long) o2[1] >= 0 ? 1 : -1);

        int n = points.length;
        int right = points[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (points[i][0] > right) {
                ++ans;
                right = points[i][1];
            }
        }
        return ans;

    }
}
