package leetcode.a0;

import java.util.*;

/**
 * Longest Substring Without Repeating Characters
 * 最长无重复子串
 * {sliding window},{two pointers}
 */
public class _3Solution {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int ans = 0;
        int i = 0;
        int j = 0;

        // a sliding window between i and j
        while (i < s.length() && j < s.length()) {

            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return ans;
    }

    /**
     * 通过使用数组进行优化，时间优化到1ms
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        // int n = s.length();
        int set[] = new int[128];
        int ans = 0, i = 0, j = 0;
        char[] ss = s.toCharArray();

        while (i < ss.length && j < ss.length) {
            // try to extend the range [i, j]
            if (set[ss[j]] == 0) {
                set[ss[j++]]++;
                ans = Math.max(ans, j - i);
            } else {
                set[ss[i++]]--;
            }
        }
        return ans;
    }
}
