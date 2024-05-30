package leetcode.a300;

/**
 * 最长子串，要求子串中的所有字符至少重复出现k次
 * {dfs}
 */
public class _395Solution {

    /**
     * 先找整体上不满足出现k次的字符，然后这个字符将
     * 字符串划分成区间，然后在区间上递归的查找
     * 
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {

        return dfs(s, 0, s.length() - 1, k);

    }

    private int dfs(String s, int start, int end, int k) {

        int[] alph = new int[26];
        for (int i = start; i <= end; i++) {
            alph[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (alph[i] < k && alph[i] > 0) {
                split = (char) ('a' + i);
                break;
            }
        }
        if (split == 0)
            return end - start + 1;

        int i = start;
        int j = 0;
        int len = 0;
        while (i <= end) {
            while (i <= end && split == s.charAt(i)) {
                i++;
            }

            j = i;

            while (j <= end && split != s.charAt(j)) {
                j++;
            }

            len = Math.max(len, dfs(s, i, j - 1, k));
            i = j;

        }

        return len;

    }
}
