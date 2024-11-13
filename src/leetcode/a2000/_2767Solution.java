package leetcode.a2000;

/**
 * 将二进制字符串分割为最少的美丽字符串
 * 美丽字符串定义为5的幂，且不能有前导0
 * {dp}
 */
public class _2767Solution {

    public int minimumBeautifulSubstrings(String s) {
        // dp[i] 表示长为 i 的前缀字符串中，可被分割出来的子串最少数量
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        // 1本身也是5的幂
        dp[1] = s.charAt(0) == '1' ? 1 : -1;
        // 推导 dp[i]： 若字符串 j ~ i-1 的子串，不含有前导0，并且属于 5 的幂，并且 dp[j] > 1 说明 0~j-1 的子串可被分割，则
        // dp[i] = min(dp[j] + 1)；
        for (int i = 2; i <= s.length(); i++) {
            dp[i] = -1;
            for (int j = 0; j < i; j++) {
                if (isPowerOfFive(s, j, i - 1) && dp[j] >= 0) {
                    if (dp[i] == -1 || dp[i] > dp[j] + 1)
                        dp[i] = dp[j] + 1;
                }
            }
        }
        return dp[s.length()];
    }

    private boolean isPowerOfFive(String s, int start, int end) {
        if (s.charAt(start) == '0')
            return false;
        // 计算从[start,end]的值，是否可被 5 的幂
        int val = 0;
        for (int i = start; i <= end; i++) {
            val = val * 2 + s.charAt(i) - '0';
        }
        return val == 1 || val == 5 || val == 25 || val == 125 || val == 625 || val == 3125 || val == 15625
                || val == 78125 || val == 390625 || val == 1953125;
    }
}
