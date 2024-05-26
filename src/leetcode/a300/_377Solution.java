package leetcode.a300;
/**
 * nums数组中，元素之和等于target的不同组合数
 * nums本身元素没有重复，但是可以重复选取相同元素
 * {dp}
 */
public class _377Solution {
 
    /**
     * dp问题，定义dp[i]为元素之和等于i的不同组合数 
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

}
