package leetcode.a700;
/**
 * 寻找数组的中心元素，使得元素左边的子数组之和等于右边的子数组之和
 * {easy}
 */
public class _724Solution {

    public int pivotIndex(int[] nums) {

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int half = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (sum - nums[0] == 0) {
                    return 0;
                } else {
                    half += nums[0];
                }
            } else {
                if (half * 2 == sum - nums[i])
                    return i;
                else
                    half += nums[i];
            }

        }

        return -1;

    }
}
