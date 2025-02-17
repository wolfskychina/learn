package leetcode.a3000;

import java.util.Arrays;

/**
 * 使数组中位数等于k的最少操作数
 * 这里定义的中位数当数组的数字个数为偶数的时候，中位数选中间较大的那个数
 * {greedy},{median},{math}
 */
public class _3107Solution {

    /**
     * 改变中位数的大小，需要调整的最少数字
     * 排序后向改变的一侧方向遍历，需要调整的数字最少
     * @param nums
     * @param k
     * @return
     */
    public long minOperationsToMakeMedianK(int[] nums, int k) {

        Arrays.sort(nums);

        long res = 0L;
        int ori = nums[nums.length / 2];
        if (ori == k)
            return res;
        if (ori > k) {
            for (int i = nums.length / 2; i >= 0; i--) {
                if (nums[i] > k) {
                    res += nums[i] - k;
                } else
                    break;
            }
        } else {
            for (int i = nums.length / 2; i < nums.length; i++) {
                if (nums[i] < k) {
                    res += k - nums[i];
                } else
                    break;
            }

        }

        return res;
    }
}
