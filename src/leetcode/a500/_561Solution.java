package leetcode.a500;

import java.util.Arrays;

/**
 * 将有偶数个个数的数组两两配对，每个配对中较小元素的和的最大值是多少
 */
public class _561Solution {

    /**
     * 排序后取所有第二大的元素之和
     * 满足贪心规则
     * {greedy}
     * onlogn
     * 
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;

    }

}
