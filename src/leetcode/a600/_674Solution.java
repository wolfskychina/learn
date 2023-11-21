package leetcode.a600;

/**
 * 最长连续上升子数组
 * {easy}
 */
public class _674Solution {

    public int findLengthOfLCIS(int[] nums) {

        int max = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1])
                count++;
            else {
                max = Math.max(max, count);
                count = 1;
            }

        }

        return Math.max(count, max);
    }
}
