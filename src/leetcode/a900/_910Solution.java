package leetcode.a900;

import java.util.Arrays;

/**
 * 最小差值
 * 数组里面的每个数字必须选择增加k或者减少k
 * 所能形成的可能数组中最大值和最小值最接近的差值
 */
public class _910Solution {
   
    /**
     * {greedy}
     * 因为每个数字都必须变大和变小
     * 根据贪心的规则，让小的元素变大，大的元素变小
     * 才可能获得更小的差值
     * 那么可以排序后遍历每个数字，让前面的数字变大，后面数字变小
     * @param nums
     * @param k
     * @return
     */
    public int smallestRangeII(int[] nums, int k) {

        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[n - 1] - nums[0];

        int maxend = nums[n - 1] - k;
        int minstart = nums[0] + k;
        for (int i = 1; i < n; i++) {
            int mx = Math.max(nums[i - 1] + k, maxend);
            int mn = Math.min(minstart, nums[i] - k);
            ans = Math.min(ans, mx - mn);
        }
        return ans;
    }
}
