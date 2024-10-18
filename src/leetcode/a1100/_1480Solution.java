package leetcode.a1100;
/**
 * running sum
 * {easy}
 */
public class _1480Solution {
   
    public int[] runningSum(int[] nums) {

        for(int i=1;i<nums.length;i++){
            nums[i] +=nums[i-1];
        }
        return nums;

    }
}
