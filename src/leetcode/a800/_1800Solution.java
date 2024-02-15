package leetcode.a800;
/**
 * 最大升序子数组和
 * {easy}
 */
public class _1800Solution {
   
    public int maxAscendingSum(int[] nums) {

        int i=0;
        int max =0;
        int tmp =0;
        while(i<nums.length){

            tmp =nums[i];
            while(i<nums.length-1&&nums[i+1]>nums[i]){
                i++;
                tmp+=nums[i];
            }
            max = Math.max(max,tmp);
            i++;
        }
        return max;

    }
}
