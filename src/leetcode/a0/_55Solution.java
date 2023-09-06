package leetcode.a0;

public class _55Solution {
    public boolean canJump(int[] nums){
        int lastPos = nums.length -1;
        for(int i = nums.length-1; i>=0;i--){
            if(i+nums[i]>=lastPos){
                lastPos = i;

            }
        }

        return lastPos == 0;
    }
    public boolean canJump2(int[] nums) {

        int curFarthest = 0;
        for (int i = 0; i < nums.length; i++) {
            curFarthest = Math.max(curFarthest, i +nums[i]);
            if(nums[i] == 0 && i < nums.length - 1 && i == curFarthest ) return false;
        }
        return true;
    }


}
