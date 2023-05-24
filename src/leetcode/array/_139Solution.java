package leetcode.array;

import java.util.Set;
/**
 * 判断一个单词能否分拆成字典里面的单词
 */
public class _139Solution {
   
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s.length() == 0) return false;
        
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        //dp[i] true ==   s.substring(0,i) true
        
        for (int i = 0; i < s.length()+1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
}
