package leetcode.a800;

import java.util.Arrays;
/**
 * 从一组学生中挑选k个学生，
 * 这k个学生中分数的最小差值可能是多少
 * {sliding window}
 */
public class _1984Solution {
   
    public int minimumDifference(int[] nums, int k) {

        if(k==1) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i=0;i+k-1<nums.length;i++){
            min = Math.min(min,nums[i+k-1]-nums[i]);
        }
        return min;

    }
}
