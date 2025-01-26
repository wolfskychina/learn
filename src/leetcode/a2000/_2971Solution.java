package leetcode.a2000;

import java.util.Arrays;

/**
 * 根据给出的线段长度，找到能组成的最大周长的多边形
 * 所有小的线段长度和大于最长线段，那么就能组成一个多边形
 * {greedy},{prefix sum}
 */
public class _2971Solution {

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long prefix[] = new long[nums.length - 1];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = nums.length - 1; i > 1; i--) {
            if (prefix[i - 1] > nums[i])
                return prefix[i - 1] + nums[i];
        }
        return -1;

    }
}
