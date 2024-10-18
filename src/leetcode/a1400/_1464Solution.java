package leetcode.a1400;

import java.util.Arrays;
/**
 * {easy}
 */
public class _1464Solution {
   
    public int maxProduct(int[] nums) {

        Arrays.sort(nums);
        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }
}
