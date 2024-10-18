package leetcode.a1700;
/**
 * 可以形成的最大边长的矩形的数量
 * {easy}
 */
public class _1725Solution {
   
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0, ans = 0;
        for (int[] r : rectangles) {
            int cur = Math.min(r[0], r[1]);
            if (cur == max) ans++;
            else if (cur > max) {
                max = cur; ans = 1;
            }
        }
        return ans;
    }
}
