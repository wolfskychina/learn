package leetcode.a800;
/**
 * 判断是个数组是否是单调序列
 * {easy}
 */
public class _896Solution {
   
    public boolean isMonotonic(int[] nums) {

        boolean increase = true;
        boolean decrease = true;
        for(int i=1;i<nums.length;i++){

            if(nums[i]>nums[i-1])
                decrease = false;
            if(nums[i]<nums[i-1])
                increase = false;
            if(!increase&&!decrease) return false;
        }   
        return increase|decrease;
    }
}
