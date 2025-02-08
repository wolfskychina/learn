package leetcode.a400;

import java.util.Arrays;

/**
 * 最少需要多少次射击能打爆所有的气球
 * 如果是求一次射击能够打爆的最多气球呢？
 */
public class _452Solution {

    /**
     * 435题的变种
     * TODO 需要注意两个数比较大小时候可能会溢出
     * {greedy},{interval}
     * 
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {

        if (points.length == 0) {
            return 0;
        }

        // 直接比大小，不要做减法，避免溢出
        Arrays.sort(points, (o1, o2) -> o1[1] >= (long) o2[1] ? 1 : -1);
        // Arrays.sort(points, (o1, o2) -> (long) o1[1] - (long) o2[1] >= 0 ? 1 : -1);

        int n = points.length;
        int right = points[0][1];
        int ans = 1;

        for (int i = 1; i < n; ++i) {
            if (points[i][0] > right) {
                ++ans;

                right = points[i][1];
            } else {

            }
        }

        return ans;

    }

    public static void main(String[] args) {
        _452Solution so = new _452Solution();
        int[][] points = { { 9, 16 }, { 6, 16 }, { 1, 9 }, { 3, 15 } };
        // int[][] points = { { 2, 3 }, { 2, 3 }, { 1, 4 }, { 2, 5 } };
        // int [][] points = {{10,16},{2,8},{1,6},{7,12}};
        // int [][] points = {{1,2},{3,4},{5,6},{7,8}};
        so.findMinArrowShots(points);
    }
}
