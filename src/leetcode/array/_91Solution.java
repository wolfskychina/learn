package leetcode.array;

public class _91Solution {
   
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];

        // dp[0]这里是一个trick，主要是为了计算dp[2]
        // 因为下面递推式dp[i] += dp[i-2]; 当i=2时且前两位能解码时，相当于新增了一种解码方式
        // 因此dp[0]需要等于1，否则根据递推式，少了一种解码方式
        // 这个递推的边界条件有点trick
        dp[0] = 1;

        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        if(n>=2){
            dp[2] += (Integer.valueOf(s.substring(0, 2))>=10&&
Integer.valueOf(s.substring(0, 2))<=26)?1:0;
            dp[2] += (Integer.valueOf(s.substring(1, 2))>=1&& 
Integer.valueOf(s.substring(1, 2))<=9)?dp[1]:0;
        }

        for(int i = 3; i <= n; i++) {
            // 截出来的是第i个字符
            int first = Integer.valueOf(s.substring(i-1, i));
            // 截出来的是第i-1 - i个字符
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
               dp[i] = dp[i-1];  
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
