package leetcode.array;

public class _41Solution {

    public int firstMissingPositive(int[] nums){
        if(nums ==null || nums.length==0) return 1;

        for(int i= 0; i<nums.length;i++){

            int curr = nums[i];
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
