package leetcode.array;

/**
 * 不能遍历相邻的数字，求能够遍历的数字之和的最大值
 */
public class _198Solution {
    /**
     * 一开始考虑简单了，只考虑了奇偶问题
     * 可能存在跳过两个相邻格子的情况，变成一个明显的dp问题
     */
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;
        if(nums.length ==1) return nums[0];

        int [] max = new int[nums.length];

        max[0] = nums[0];
        max[1] = Math.max(nums[0], nums[1]);

        for(int i =2 ;i<nums.length ;i++){

            max[i] = Math.max(max[i-1], max[i-2]+nums[i]);
        }


        return max[nums.length-1];
    }
}
