package leetcode.a2000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中最长的方波子序列
 * {hashmap}
 */
public class _2501Solution {

    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.get(nums[i]) != null)
                continue;
            if (map.get(nums[i] * nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i] * nums[i]) + 1);

            }
        }
        int max = 0;
        for (int i : map.values()) {
            max = Math.max(max, i);
        }
        return max == 1 ? -1 : max;
    }
}
