package leetcode.a2000;
/**
 * 最长的严格递增或递减子数组
 * {easy}
 */
public class _3105Solution {
   
    public int longestMonotonicSubarray(int[] nums) {

        int maxincr =1;
        int maxdesc =1;
        int max =1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                maxincr++;
                max = Math.max(max,maxincr);
                maxdesc=1;
            }else if(nums[i]<nums[i-1]){
                maxdesc++;
                max = Math.max(max,maxdesc);
                maxincr=1;
            }else{
                maxdesc=1;
                maxincr=1;
            }
        }
        return max;
    }
}
