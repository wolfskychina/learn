package leetcode.a2000;

import java.util.Arrays;

/**
 * 统计公平数对的数目
 * 任取两个不同的数之和在lower和upper之间的数对的数量
 * 
 * 0 <= i < j < n, and
 * lower <= nums[i] + nums[j] <= upper
 */
public class _2563Solution {

    /**
     * 固定i值然后找对应符合条件的j的上下限
     * {binary search}
     * 
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {

            int left = find(nums, i + 1, lower - nums[i] - 1);
            int right = find(nums, i + 1, upper - nums[i]);

            ans += right - left;
        }

        return ans;

    }

    private int find(int[] nums, int l, int tar) {
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= tar)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    public long countFairPairs1(int[] nums, int lower, int upper) {
        long ans = 0;
        Arrays.sort(nums);
        int left = nums.length;
        int right = nums.length;
        for (int j = 0; j < nums.length; j++) {
            while (right > 0 && nums[right - 1] > upper - nums[j]) {
                right--;
            }
            while (left > 0 && nums[left - 1] >= lower - nums[j]) {
                left--;
            }
            ans += Math.min(right, j) - Math.min(left, j);
        }
        return ans;
    }
}
