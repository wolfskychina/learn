package leetcode.a500;

import java.util.Arrays;

public class _532Solution {

    public int findPairs(int[] nums, int k) {

        Arrays.sort(nums);
        int l=0;
        int r=0;
        int res =0;
        int res0 =0;
        while(l<nums.length&&r<nums.length){
            int countl =1;
            while(l+1<nums.length && nums[l]==nums[l+1]){
                l++;
                countl++;
            }
            if(k==0){
                
            }else{

                r = l+1;
                while(r<nums.length && nums[r]-nums[l]<k){
                    r++;
                }
    
            }
           

        }

    }
}
