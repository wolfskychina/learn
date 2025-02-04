package leetcode.a1500;

/**
 * 最少反转次数
 * 同3192题
 * {greedy}
 */
public class _1529Solution {
   
    public int minFlips(String s) {
        int ans = 0;
        int n = s.length();
        if (s.charAt(0) == '1') ++ans;
        for (int i = 0; i < n-1; ++i) {
            if (s.charAt(i) != s.charAt(i+1)) {
                ++ans;
            }
        }
        return ans;
    }
}
