package leetcode.a3000;

import java.util.Arrays;

/**
 * 以坐标0为中心的正方形最多能包含多少不同字符的点
 * {greedy},需要维护每种字符次小距离的最小值
 */
public class _3143Solution {

    public int maxPointsInsideSquare(int[][] points, String s) {
        int[] minArray = new int[26];
        Arrays.fill(minArray, Integer.MAX_VALUE);
        int minPoint = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int singleMaxPoint = Math.max(Math.abs(point[0]), Math.abs(point[1]));
            int charNum = s.charAt(i) - 'a';
            if (singleMaxPoint < minArray[charNum]) {
                minPoint = Math.min(minArray[charNum], minPoint);
                minArray[charNum] = singleMaxPoint;
            } else {
                minPoint = Math.min(singleMaxPoint, minPoint);
            }
        }
        int ans = 0;
        for (int in : minArray) {
            if (in < minPoint) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        _3143Solution so = new _3143Solution();
        int[][] points = { { 1, 1 }, { -1, -1 }, { 2, 2 } };
        String s = "ccd";
        so.maxPointsInsideSquare(points, s);
    }
}
