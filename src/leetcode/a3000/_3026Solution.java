package leetcode.a3000;

import java.util.HashMap;
import java.util.Map;

/**
 * 最大好子数组和
 * 
 * 满足首尾元素差的绝对值为k |nums[i] - nums[j]| == k , nums[i..j]
 * 的子数组的和的最大值
 * 
 */
public class _3026Solution {

    /**
     * 因为绑定的是首尾元素，不需要保存索引，而是直接用元素值绑定对应前缀和即可
     * TODO 前缀和对应的key不再是坐标而是对应元素的
     * 
     */
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = Long.MIN_VALUE;
        long sum = 0;
        Map<Integer, Long> minS = new HashMap<>();
        for (int x : nums) {
            long s1 = minS.getOrDefault(x - k, Long.MAX_VALUE / 2);
            long s2 = minS.getOrDefault(x + k, Long.MAX_VALUE / 2);
            // sum是前一位的前缀和，算区间和的时候需要临时加上x
            ans = Math.max(ans, sum + x - Math.min(s1, s2));
            // 跟具体的坐标没关系，只存坐标前一位前缀和的最小值
            // 确保区间和能够最大
            // x在后续遍历中作为左侧值i
            minS.merge(x, sum, Math::min);
            sum += x;
        }
        return ans > Long.MIN_VALUE / 4 ? ans : 0;
    }
}
