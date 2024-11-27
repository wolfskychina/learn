package leetcode.a2000;

/**
 * 找出满足差值条件的下标，要求：
 * abs(i - j) >= indexDifference 且
 * abs(nums[i] - nums[j]) >= valueDifference
 * {sliding window},{two pointers}
 */
public class _2905Solution {

    /**
     * 注意因为是差的绝对值，因此
     * 不仅要维护i之前的最小值，还要维护i之前的最大值
     * @param nums
     * @param indexDifference
     * @param valueDifference
     * @return
     */
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {

        int min = (int) 1e9 + 1;
        int max = 0;
        int minidx = -1;
        int maxidx = -1;
        for (int i = indexDifference; i < nums.length; i++) {
            if (min > nums[i - indexDifference]) {
                min = nums[i - indexDifference];
                minidx = i - indexDifference;
            }
            if (max < nums[i - indexDifference]) {
                max = nums[i - indexDifference];
                maxidx = i - indexDifference;
            }
            if (Math.abs(nums[i] - min) >= valueDifference)
                return new int[] { minidx, i };
            if (Math.abs(nums[i] - max) >= valueDifference)
                return new int[] { maxidx, i };
        }
        return new int[] { -1, -1 };

    }
}
