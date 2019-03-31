package leetcode.array;

import java.util.*;

/**
 * Longest Substring Without Repeating Characters
 * 最长无重复子串
 */
public class _3Solution {

    public int lengthOfLongestSubstring(String s) {
        // int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        //i :left  j:right

        while (i <  s.length() && j < s.length()) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

}
