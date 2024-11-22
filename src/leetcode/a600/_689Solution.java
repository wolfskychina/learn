package leetcode.a600;

/**
 * 数组中三个长度为k的非重叠子数组的和的最大值
 * {sliding window},{greedy}
 */
public class _689Solution {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];
        // 三个邻接窗口同时向右侧遍历
        int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
        int sum2 = 0, maxSum12 = 0, maxSum12Idx1 = 0, maxSum12Idx2 = 0;
        int sum3 = 0, maxTotal = 0;
        for (int i = k * 2; i < nums.length; ++i) {
            sum1 += nums[i - k * 2];
            sum2 += nums[i - k];
            sum3 += nums[i];
            if (i >= k * 3 - 1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Idx = i - k * 3 + 1;
                }
                if (maxSum1 + sum2 > maxSum12) {
                    maxSum12 = maxSum1 + sum2;
                    // 使得前两个子数组和最大时的第一个子数组位置
                    // 不一定是已经发现的第一个子数组中最大的
                    // 因为还受第二个子数组大小的影响
                    // 有可能maxSum1发现了更大的，但是这时sum2反而变小了
                    // maxSum12Idx1表示前两个数组和最大时第一个子数组的位置
                    maxSum12Idx1 = maxSum1Idx;
                    maxSum12Idx2 = i - k * 2 + 1;
                }
                if (maxSum12 + sum3 > maxTotal) {
                    // 三个子数组最大和依赖于前两个子数组的最大和
                    // 体现了贪心的思想
                    maxTotal = maxSum12 + sum3;
                    ans[0] = maxSum12Idx1;
                    ans[1] = maxSum12Idx2;
                    ans[2] = i - k + 1;
                }
                sum1 -= nums[i - k * 3 + 1];
                sum2 -= nums[i - k * 2 + 1];
                sum3 -= nums[i - k + 1];
            }
        }
        return ans;
    }
}
