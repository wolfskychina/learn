package leetcode.a0;
/**
 * 最大子数组和
 * {classic}
 */
public class _53Solution {
   
    /**
     * {dp} 如果之前的和加上当前值变小了，那么之前的和根本就没有必要保留
     * 新的子数组的边界由当前值开始即可
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum =0;
        for(int i:nums){
            sum = Math.max(sum+i,i);
            max = Math.max(max, sum);
        }
        return max;
    }
}
