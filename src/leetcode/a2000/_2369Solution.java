package leetcode.a2000;

/**
 * 检查数组是否存在有效划分
 * 如果数组的一个划分能够使得每个子数组满足
 * 长度为2且a1=a2或长度为3且a1=a2=a3
 * 或者长度为3且a1=a2+1=a3+2
 * {dp}
 */
public class _2369Solution {

    public boolean validPartition(int[] nums) {

        boolean[] dp = new boolean[nums.length + 1];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                dp[i + 1] |= dp[i - 1];
            }
            if (i > 1) {
                if (nums[i] == nums[i - 1] && nums[i] == nums[i - 2])
                    dp[i + 1] |= dp[i - 2];
                if (nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1)
                    dp[i + 1] |= dp[i - 2];
            }
        }
        return dp[nums.length];
    }
}
