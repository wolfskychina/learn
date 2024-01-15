package leetcode.a800;
/**
 * 找出满足条件的下标
 * {easy}
 */
public class _2903Solution {

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                if (Math.abs(i - j) >= indexDifference &&
                        Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] { -1, -1 };
    }
}
