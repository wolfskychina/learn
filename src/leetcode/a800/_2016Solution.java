package leetcode.a800;

/**
 * 增量元素之间的最大差值
 */
public class _2016Solution {

    public int maximumDifference(int[] nums) {

        boolean found = false;
        int maxd = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] < nums[j]) {
                    found = true;
                    maxd = Math.max(maxd, nums[j] - nums[i]);
                }
            }
        }

        if (found)
            return maxd;
        return -1;
    }

    /**
     * 因为要求增量元素i<j，所以左侧只需要保留当前的最小值即可
     * on时间复杂度
     * @param nums
     * @return
     */
    public int maximumDifference1(int[] nums) {
        int val = -1, min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                val = Math.max(val, nums[i] - min);
            }
        }
        return val;
    }
}
