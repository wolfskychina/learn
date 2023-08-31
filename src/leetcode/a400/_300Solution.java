package leetcode.a400;

/**
 * 数字数组中最长严格连续上升的子序列
 * 是子序列而不是子数组
 */
public class _300Solution {
    /**
     * dp解决方案，dp[n]可以由dp[0]...dp[n-1]确定
     * on2的时间复杂度
     * 
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        int[] count = new int[nums.length];
        for (int i = 0; i < count.length; i++) {
            count[i] = 1;
        }

        int max = 1;
        for (int i = 1; i < count.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
        }

        
        for (int i = 0; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }

        return max;

    }
}
