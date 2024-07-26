package leetcode.a2000;

import java.util.Arrays;

/**
 * 最小的分区值
 * {easy}
 */
public class _2740Solution {

    public int findValueOfPartition(int[] nums) {

        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {

            min = Math.min(nums[i + 1] - nums[i], min);
        }

        return min;
    }
}
