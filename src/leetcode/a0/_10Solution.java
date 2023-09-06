package leetcode.a0;

public class _10Solution {
   
    boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];

        // i,j表示子串的长度
        // 边界条件为i=0 j=0 j=1
        // j=0时p为空串，只能匹配空串，其他默认为false
        dp[0][0] = true;
        // j=1时p只有一个字符，只能匹配一个字符，其他全部为false
        dp[1][1] = s.charAt(0)== p.charAt(0) || p.charAt(0) == '.';
        // i=0时s为空串，p只有类似a*b*c*d*这样的形式才可以成功匹配
        for (int j = 2; j < p.length() + 1; j += 2)
        {
            // 前0位和前j-2位是匹配的，且第j位是*
            dp[0][j] = dp[0][j - 2] && p.charAt(j-1) == '*';
        }


        // i表示s的前i位，j表示p的前j为
        for (int i = 1; i < s.length() + 1; i++)
        {
            
            for (int j = 2; j < p.length() + 1; j++)
            {
                if (p.charAt(j-1) != '*')
                {
                    // 前i-1位和前j-1位是匹配的，且第i位和第j位是匹配的
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                }
                else
                {
                    //当p[j-1]出现0次时，前i位和前j-2位是匹配的
                    //当p[j-1]出现1次或多次时，第i位一定匹配第j-1位，且前i-1位一定和前j位是匹配的。
                    //p可能出现.*这种序列的情况
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && (s.charAt(i-1)== p.charAt(j-2) || p.charAt(j-2) == '.');
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
