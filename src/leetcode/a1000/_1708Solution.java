package leetcode.a1000;
/**
 * 长度为k的最大子数组
 * {easy}
 */
public class _1708Solution {
   
    public int[] largestSubarray(int[] nums, int k) {

        int max =0;
        for(int i=0;i<nums.length-k+1;i++){
            if(nums[i]>nums[max])
                max = i;
        }
        int res[]=new int[k];
        for(int i=0;i<res.length;i++){
            res[i]=nums[max++];
        }
        return res;
    }
}
