package leetcode.a500;

import java.util.Arrays;

/**
 * 最长和谐子序列
 */
public class _594Solution {

    /**
     * {sorting}
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {

        int max = 0;
        Arrays.sort(nums);
        int last = -1;
        int i = 0;
        int lastNum = Integer.MIN_VALUE;
        while (i < nums.length) {
            int l = i;
            i++;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            int count = i - l;
            if (last != -1 && (lastNum == nums[l] + 1 || lastNum == nums[l] - 1))
                max = Math.max(count + last, max);
            last = count;
            lastNum = nums[l];
        }
        return max;

    }
}
