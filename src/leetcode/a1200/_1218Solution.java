package leetcode.a1200;

/**
 * 最长定差子序列
 */
public class _1218Solution {
   
    int N = 40009, M = N / 2;
    /**
     * 解空间dp
     * @param arr
     * @param d
     * @return
     */
    public int longestSubsequence(int[] arr, int d) {
        int ans = 1;
        int[] hash = new int[N];
        for (int i : arr) {
            hash[i + M] = hash[i - d + M] + 1;
            ans = Math.max(ans, hash[i + M]);
        }
        return ans;
    }
}
