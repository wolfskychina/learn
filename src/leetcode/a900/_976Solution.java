package leetcode.a900;

import java.util.Arrays;

/**
 * 三角形的最大周长
 * {easy}
 */
public class _976Solution {
   
    public int largestPerimeter(int[] nums) {

        Arrays.sort(nums);
        int i=nums.length-1;
        for(;i-2>=0;i--){
            if(nums[i-2]+nums[i-1]>nums[i])
                return nums[i-2]+nums[i-1]+nums[i];
        }
        return 0;
    }
}
