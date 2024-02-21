package leetcode.a2000;
/**
 * 特殊元素平方和
 * {easy}
 */
public class _2778Solution {
   
    public int sumOfSquares(int[] nums) {

        int sum=0;
        for(int i=0;i<nums.length;i++){

            if(nums.length%(i+1)==0)
                sum+=nums[i]*nums[i];
        }
        return sum;
    }
}
