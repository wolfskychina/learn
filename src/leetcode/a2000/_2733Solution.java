package leetcode.a2000;

import java.util.Arrays;

/**
 * 非重复数组中既不是最大也不是最小的值
 * {easy}
 */
public class _2733Solution {

    public int findNonMinOrMax(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : nums) {

            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        for (int i : nums) {

            if (i != max && i != min)
                return i;
        }
        return -1;
    }

    /**
     * 题目的前提是数组中的数字都是非重复的，所以只需要看前三个数字
     * 里面就一定有非最大和非最小的数
     * @param nums
     * @return
     */
    public int findNonMinOrMax1(int[] nums) {
      
        if (nums.length < 3) return -1;
        Arrays.sort(nums, 0, 3); // 只对前三个数排序
        return nums[1];

    }
}
