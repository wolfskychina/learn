package leetcode.a1800;

import java.util.Arrays;

/**
 * 数组元素配对后的最大数对和的最小可能值
 * {greedy},{easy}
 */
public class _1877Solution {
   
    public int minPairSum(int[] nums) {
        
        Arrays.sort(nums);
        int max = 0;
        
        for(int i=0;i<nums.length/2;i++){
            max = Math.max(nums[i]+nums[nums.length-i-1],max);
        }
        return max;
    }
}
