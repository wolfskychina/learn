package leetcode.a2000;

/**
 * Split Array Into Maximum Number of Subarrays
 * 将数组分隔成数组最多的子数组
 * 使得这些子数组的分值的总和最小
 * 子数组的分值是指所有元素的逻辑与运算结果
 */
public class _2871Solution {

    /**
     * {bit manipulation}
     * @param nums
     * @return
     */
    public int maxSubarrays(int[] nums) {

        int tar = Integer.MAX_VALUE;
        for (int i : nums) {

            tar = tar & i;
        }

        if (tar != 0)
            return 1;

        int idx = 0;
        int tmp = Integer.MAX_VALUE;
        int res = 0;

        while (idx < nums.length) {

            tmp = tmp & nums[idx++];
            if (tmp == tar) {
                res++;
                tmp = Integer.MAX_VALUE;
            }
        }

        return res;
    }
}
