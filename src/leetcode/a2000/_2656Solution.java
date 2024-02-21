package leetcode.a2000;
/**
 * n个元素的最大和
 * {easy}
 */
public class _2656Solution {
   
    public int maximizeSum(int[] nums, int k) {

        int max =0;
        for(int i:nums){
            max = Math.max(max,i);
        }
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=max++;
            
        }
        return sum;
    }
}
