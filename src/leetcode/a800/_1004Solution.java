package leetcode.a800;
/**
 * 01序列中，最多允许反转k个0成为1
 * 问能够构成的最长的连续1有多长
 */
public class _1004Solution {
  
    /**
     * {sliding window},{two pointers}
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {

        int max =0;
        int l=0;
        int r=0;
        int zeroinwin =0;
        while(r<nums.length){

            while(r<nums.length&&nums[r]==1){
                r++;
            }
            max = Math.max(max,r-l);
            if(r==nums.length) break;

            if(zeroinwin ==k){

                while(nums[l]==1){
                    l++;
                }
                l++;
                r++;
            }else{
                zeroinwin++;
                r++;
                max = Math.max(max,r-l);
            }
        }

        return max;
    }
}
