package leetcode.a0;

public class _41Solution {

    public int firstMissingPositive(int[] nums){
        if(nums ==null || nums.length==0) return 1;

        for(int i= 0; i<nums.length;i++){

            int curr = nums[i];
            // 随着逐渐有序，下面会执行的越来越少
            // 实际执行次数小于总的数组长度n
            while(curr -1>=0&& curr -1 <nums.length&&nums[curr-1]!=curr){
                int next = nums[curr-1];
                nums[curr-1] =curr;
                curr = next;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] !=i+1) return i+1;
        }

        return nums.length+1;
    }
}
