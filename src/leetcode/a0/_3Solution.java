package leetcode.a0;

import java.util.*;

/**
 * Longest Substring Without Repeating Characters
 * 最长无重复子串
 */
public class _3Solution {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int ans =0;
        int i = 0;
        int j = 0;

        // a sliding window between i and j
        while(i<s.length() &&j<s.length()){

            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }

        return ans;
    }

}
