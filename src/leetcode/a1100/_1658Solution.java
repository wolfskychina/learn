package leetcode.a1100;
/**
 * 一个正整数的数组，每次允许从左边或者右边选取一个元素
 * 并从x中减去这个元素，问最少多少次能使得x变成0
 * 如果无法让x变成0，返回-1
 */
public class _1658Solution {
   
    /**
     * 问题转化为从 nums中移除一个最长的子数组，使得剩余元素的和为 x
     * {two pointers}
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) target += num;
        if (target < 0) return -1; // 全部移除也无法满足要求
        int ans = -1, left = 0, sum = 0, n = nums.length;
        for (int right = 0; right < n; ++right) {
            sum += nums[right];
            while (sum > target) sum -= nums[left++]; // 缩小子数组长度
            if (sum == target) ans = Math.max(ans, right - left + 1);
        }
        return ans < 0 ? -1 : n - ans;
    }
}
