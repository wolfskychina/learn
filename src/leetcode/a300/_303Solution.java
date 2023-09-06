package leetcode.a300;
/**
 * 返回数组在坐标[left,right]之间的元素的和
 */
public class _303Solution {

    int [] sums;

    /**
     * 空间换时间，提前储存前i个数的和
     */
    public _303Solution(int[] nums) {
        this.sums = new int[nums.length];
        this.sums[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            this.sums[i] += sums[i-1]+nums[i];
        }

    }
    
    public int sumRange(int left, int right) {

        return sums[right]-(left==0?0:sums[left-1]);

    }
    
}
