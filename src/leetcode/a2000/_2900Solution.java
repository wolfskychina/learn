package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长相邻不相等子序列
 * {easy}
 */
public class _2900Solution {

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || groups[i] != groups[i + 1]) {
                ans.add(words[i]);
            }
        }
        return ans;
    }
}
