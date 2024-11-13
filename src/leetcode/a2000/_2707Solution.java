package leetcode.a2000;

import java.util.HashSet;
import java.util.Set;

/**
 * 将字符串按照字典中的词进行分割成片段，剩下无法匹配到的字符数量的最小值
 */
public class _2707Solution {

    /**
     * {dp}
     * on2，注意片段不需要切割的时候，以及遍历的时候子串无法切割的时候
     * 
     * @param s
     * @param dictionary
     * @return
     */
    public int minExtraChar(String s, String[] dictionary) {

        // dp[i]表示[0,1)区间内该问题的最小值
        int[] dp = new int[s.length() + 1];
        Set<String> set = new HashSet<>();
        for (String str : dictionary) {
            set.add(str);
        }
        for (int i = 1; i < dp.length; i++) {

            // 注释的地方可以优化
            //if (set.contains(s.substring(0, i))) {
            //    dp[i] = 0;
            //} else {
                dp[i] = i;
                for (int j = 0; j < i; j++) {
                    if (set.contains(s.substring(j, i)))
                        dp[i] = Math.min(dp[i], dp[j]);
                    else
                        // 不匹配的情况也要计算
                        dp[i] = Math.min(dp[i], dp[j] + i - j);
                }
            //}

        }

        return dp[dp.length - 1];
    }
}
