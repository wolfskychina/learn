package leetcode.a2000;

import java.util.Arrays;
import java.util.List;

/**
 * 和为目标值的最长序列的长度
 * {dp} 01背包问题
 */
public class _2915Solution {

    /**
     * 直接把结果当作一个维度遍历
     * @param nums
     * @param target
     * @return
     */
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {

        int[] f = new int[target + 1];
        Arrays.fill(f, Integer.MIN_VALUE);
        f[0] = 0;
        int s = 0;
        for (int x : nums) {
            s = Math.min(s + x, target);
            for (int j = s; j >= x; j--) {
                // x本身可能选也可能不选
                f[j] = Math.max(f[j], f[j - x] + 1);
            }
        }
        return f[target] > 0 ? f[target] : -1;

    }
}
