package leetcode.a2000;

/**
 * 每个字符最多出现两次的最长字符串
 * {two pointers}
 */
public class _3090Solution {

    public int maximumLengthSubstring(String S) {
        char[] s = S.toCharArray();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length; i++) {
            int b = s[i] - 'a';
            cnt[b]++;
            while (cnt[b] > 2) {
                cnt[s[left++] - 'a']--;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
