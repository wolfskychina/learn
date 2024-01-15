package leetcode.a800;
/**
 * 最小操作使数组严格递增
 * {easy}
 */
public class _1827Solution {
   
    public int minOperations(int[] nums) {

        int count =0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                count+=nums[i-1]-nums[i]+1;
                nums[i]=nums[i-1]+1;
            }
        }
        return count;
    }
       
}
