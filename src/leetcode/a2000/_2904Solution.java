package leetcode.a2000;

/**
 * Shortest and Lexicographically Smallest Beautiful String
 * 最短且字典序最小的美丽子串(指子串中的1的数量不超过k)
 * {two pointers}
 * 
 */
public class _2904Solution {

    public String shortestBeautifulSubstring(String S, int k) {
        if (S.replace("0", "").length() < k) {
            return "";
        }
        char[] s = S.toCharArray();
        String ans = S;
        int cnt1 = 0, left = 0;
        for (int right = 0; right < s.length; right++) {
            cnt1 += s[right] - '0';
            // 左侧连续为0的都可以跳过 因为势必会使最短长度减少
            while (cnt1 > k || s[left] == '0') {
                cnt1 -= s[left++] - '0';
            }
            if (cnt1 == k) {
                String t = S.substring(left, right + 1);
                if (t.length() < ans.length() || t.length() == ans.length() && t.compareTo(ans) < 0) {
                    ans = t;
                }
            }
        }
        return ans;
    }
}
