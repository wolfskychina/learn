package leetcode.a2000;
/**
 * 相同分数的最大操作数目
 */
public class _3038Solution {
   
    public int maxOperations(int[] nums) {
        int count=1;
        int sum = nums[0]+nums[1];
        int i=2;
        while(i+1<nums.length){

            if(nums[i]+nums[i+1]==sum)
                count++;
            else    
                break;

            i+=2;
        }
        return count;
    }
}
