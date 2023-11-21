package leetcode.a600;
/**
 * 长度最长的严格上升子序列的数量
 * {subsequence},{LIS}
 */
public class _673Solution {

    /**
     * {dp},基于lis的dp，额外使用一个最长子序列数量的数组
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n], g = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            f[i] = g[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // g的递推关系
                    if (f[i] < f[j] + 1) {
                        f[i] = f[j] + 1;
                        // f[i]的最长上升序列的倒数第二个节点改变了，g的数量
                        // 等于新的前驱的数量
                        g[i] = g[j];
                    } else if (f[i] == f[j] + 1) {
                        g[i] += g[j];
                    }
                }
            }
            max = Math.max(max, f[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] == max)
                ans += g[i];
        }
        return ans;
    }
}
