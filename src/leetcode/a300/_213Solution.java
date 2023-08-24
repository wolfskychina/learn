package leetcode.a300;
/**
 * 抢房子问题，这次房子是环状的
 */
public class _213Solution {
    /**
     * 将环断开，首尾两个节点分开考虑，变成两个更简单的问题
     * 还是dp问题
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
   return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
   }

    private int rob(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    } 
}
