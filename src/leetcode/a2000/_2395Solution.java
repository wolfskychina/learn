package leetcode.a2000;

import java.util.HashSet;
import java.util.Set;
/**
 * 是否存在和相等的长度为2的子数组
 * {easy}
 */
public class _2395Solution {
   
    public boolean findSubarrays(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length-1;i++){
            if(set.contains(nums[i]+nums[i+1]))
                return true;
            set.add(nums[i]+nums[i+1]);
        }
        return false;
    }
}
