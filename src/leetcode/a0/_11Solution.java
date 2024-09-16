package leetcode.a0;
/**
 * 盛水最多的容器
 * {greedy},{two pointers}
 * 选择更高的一端向里收缩一定不会出现更多的水
 * 因为盛水的量由另外一侧更短的挡板决定
 * 一种违反直觉的贪心
 */
public class _11Solution {
   
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
