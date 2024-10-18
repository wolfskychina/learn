package leetcode.a1900;

public class _1911Solution {
   
    /**
     * {dp} 定义dp[i][0]是以第i个元素结尾的，长度为偶数的最大长度，
     * dp[i][1]是长度为奇数的最大长度
     * 超时了
     * @param nums
     * @return
     */
    public long maxAlternatingSum(int[] nums) {
        // nums = [4,2,5,3]
        // 
        long dp[][] = new long[nums.length+1][2];
        long max =0;
        for(int i=1;i<=nums.length;i++){
            dp[i][1] = nums[i-1];
            for(int j=1;j<i;j++){
                dp[i][0] = Math.max(dp[i][0],dp[j][1]-nums[i-1]);
                dp[i][1] = Math.max(dp[i][1],dp[j][0]+nums[i-1]);
            }
            max = Math.max(max,dp[i][1]);
        }
        return max;
        
    }

    /**
     *  dp[i][0] 和 dp[i][1] 分别为在 nums的前缀 nums[0],nums[1],…,nums[i]中选择一个子序列，
     * 并且选择的子序列的最后一个元素的下标为偶数和奇数的「最大交替和」
     * 
     */
    public long maxAlternatingSum1(int[] nums) {
        long even = nums[0], odd = 0;
        for (int i = 1; i < nums.length; i++) {
            even = Math.max(even, odd + nums[i]);
            odd = Math.max(odd, even - nums[i]);
        }
        return even;
    }
}
