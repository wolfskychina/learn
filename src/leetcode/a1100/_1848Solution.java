package leetcode.a1100;
/**
 * 到目标元素的最小距离
 * {easy}
 */
public class _1848Solution {
   
    public int getMinDistance(int[] nums, int target, int start) {
        int min1 =-1;
        for(int i=start;i<nums.length;i++){
            if(nums[i]==target){
                min1 =i;
                break;
            }
        }
        int min2 = -1;
        for(int i=start;i>=0;i--){
            if(nums[i]==target){
                min2 = i;
                break;
            }
        }
        if(min1!=-1&&min2!=-1)
            return Math.min(start-min2,min1-start);
        if(min1!=-1)
            return min1-start;
        return start-min2;
    }
}
