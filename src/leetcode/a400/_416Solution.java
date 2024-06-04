package leetcode.a400;

/**
 * 正整数数组，能够将其中的元素划分成两份，
 * 使得两个集合的元素之和相等
 * {dp}
 */
public class _416Solution {

    /**
     * 解空间是2的n次方，np问题
     * 转换为和为 target == sum/2 的背包问题
     * 能否从nums中选出合适的元素使得和等于sum/2
     * 转换为dp问题, 定义的巧妙之处在于
     * dp[i][j] i表示从[0,i]中挑选元素,j表示target,
     * j的取值范围为[0,target], 所以target不能太大，否则空间占用很高
     * 
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {
                // 如果j<num,那么num本身放不进去
                // dp[i][j] == dp[i-1][j];
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}
