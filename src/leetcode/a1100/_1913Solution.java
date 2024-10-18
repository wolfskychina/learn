package leetcode.a1100;

import java.util.Arrays;
/**
 * 两个数对之间的最大乘积的差
 * {easy}
 */
public class _1913Solution {

    public int maxProductDifference(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
    }

    public int maxProductDifference1(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        int[] firstMaxMin = getMaxMin(arr);
        int[] secondMaxMin = getMaxMin(arr);
        return firstMaxMin[0] * secondMaxMin[0] - firstMaxMin[1] * secondMaxMin[1];
    }

    private int[] getMaxMin(int[] nums) {
        int len = nums.length;
        int maxIndex = 0, minIndex = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int x = nums[i];
            if (x > max) {
                max = x;
                maxIndex = i;
            }
            if (x < min && x != 0) {
                min = x;
                minIndex = i;
            }
        }
        nums[maxIndex] = 0;
        nums[minIndex] = 0;
        return new int[] { max, min };
    }
}
