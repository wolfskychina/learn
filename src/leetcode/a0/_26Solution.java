package leetcode.a0;

public class _26Solution {
    public int removeDuplicates(int[] nums){

        if(nums == null || nums.length == 0) return 0;
        int i=0;
        for(int j=1;i<nums.length;j++){

            if(nums[j]!=nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        // return the length of the new array
        return i+1;
    }


}
