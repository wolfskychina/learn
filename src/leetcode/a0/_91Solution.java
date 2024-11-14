package leetcode.a0;

/**
 * 数字序列解码成字母有多少种可能
 * 1-A 2-B 。。。26-Z
 * {dp}
 */
public class _91Solution {

    public int numDecodings(String s) {
        char ss[] = s.toCharArray();
        int[] dp = new int[ss.length + 1];
        if (ss[0] == '0')
            return 0;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {

            if (ss[i - 1] != '0')
                dp[i] += dp[i - 1];
            if ((ss[i - 2] == '1') || (ss[i - 2] == '2' && ss[i - 1] >= '0' && ss[i - 1] <= '6'))
                dp[i] += dp[i - 2];
        }

        return dp[dp.length - 1];
    }
}
