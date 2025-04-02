package leetcode.a100;

import java.util.List;

/**
 * 判断一个单词能否分拆成字典里面的单词
 * {dp} on2的时间复杂度
 */
public class _139Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0)
            return false;

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // dp[i] true == s.substring(0,i) true
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
