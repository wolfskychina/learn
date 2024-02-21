package leetcode.a2000;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * 不同的平均值数目
 */
public class _2465Solution {
   
    /**
     * {easy}
     * @param nums
     * @return
     */
    public int distinctAverages(int[] nums) {

        Set<Double> set = new HashSet<>();
        Arrays.sort(nums);
        int l=0;
        int r=nums.length-1;
        while(l<r){

            set.add((double)(nums[l]+nums[r])/2);
            l++;
            r--;
        }
        return set.size();
    }
}
