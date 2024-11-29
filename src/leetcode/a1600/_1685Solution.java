package leetcode.a1600;

/**
 * 有序数组中每个元素和其他所有元素的差的绝对值的和
 * {prefix sum}
 */
public class _1685Solution {

    public int[] getSumAbsoluteDifferences(int[] nums) {

        int sum = 0;
        // 提前求和
        for (int n : nums) {
            sum += n;
        }
        int res[] = new int[nums.length];
        int pre = 0;
        for (int i = 0; i < res.length; i++) {

            // res[i] = nums[i] * i - pre + (sum - pre - nums[i]) - nums[i] * (res.length - i - 1);
            res[i] = nums[i]*(2*i-res.length) + sum-2*pre;
            pre+=nums[i];
        }

        return res;
    }
}
