package leetcode.a1100;
/**
 * 是否所有的1都至少间隔k位
 * {easy}
 */
public class _1437Solution {
   
    public boolean kLengthApart(int[] nums, int k) {

        int i=0;
        while(i<nums.length&&nums[i]==0)
            i++;
        if(i==nums.length) return true;
        while(i<nums.length){
            i++;
            int l=i;
            while(i<nums.length&&nums[i]==0){
                i++;
            }
            if(i==nums.length){
                return true;
            }else if(i-l<k){
                return false;
            }

        }
        return true;
    }
}
