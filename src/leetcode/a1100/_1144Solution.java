package leetcode.a1100;

import java.util.Arrays;

/**
 * 只允许递减元素的操作，从而使得元素大小呈现锯齿状
 * 的最少操作次数
 * {greedy}
 */
public class _1144Solution {

    public int movesToMakeZigzag(int[] nums) {

        int[] nums2 = Arrays.copyOf(nums, nums.length);

        int step1 = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            if (i % 2 == 0 && nums[i] <= nums[i + 1]) {
                step1 += nums[i + 1] - nums[i] + 1;
                nums[i + 1] = nums[i] - 1;
            } else if (i % 2 == 1 && nums[i] >= nums[i + 1]) {
                step1 += nums[i] - nums[i + 1] + 1;
            }
        }
        int step2 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0 && nums2[i] >= nums2[i + 1]) {
                step2 += nums2[i] - nums2[i + 1] + 1;
            } else if (i % 2 == 1 && nums2[i] <= nums2[i + 1]) {
                step2 += nums2[i + 1] - nums2[i] + 1;
                nums2[i + 1] = nums2[i] - 1;

            }
        }

        return Math.min(step1, step2);
    }

    public static void main(String[] args) {
        _1144Solution so = new _1144Solution();
        int nums[] = { 9, 6, 1, 6, 2 };
        so.movesToMakeZigzag(nums);
    }
}
