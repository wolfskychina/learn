package leetcode.a3000;

import java.util.Arrays;

/**
 * 组成目标字符串所需要的最少符合条件的前缀数量
 * 符合条件的前缀指必须是words数组中字符串的前缀
 * {trie},{dp}{classic}
 */
public class _3291Solution {

    /**
     * 向后dp，从可能到达的位置出发，最长匹配前缀都是能够到达的，dp值都可以更新
     * 不能到达的位置直接跳过
     * @param words
     * @param target
     * @return
     */
    public int minValidStrings(String[] words, String target) {

        Trie root = new Trie();
        for (String str : words) {

            root.insert(str);
        }

        int[] dp = new int[target.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < target.length(); i++) {

            if (dp[i] == Integer.MAX_VALUE)
                continue;
            int max = root.search(target.substring(i));
            for (int j = 1; j <= max; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }

        }

        return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];

    }

    private class Trie {

        Trie[] list = new Trie[26];

        int search(String tar) {

            int res = 0;
            char[] s = tar.toCharArray();
            Trie p = this;
            for (char c : s) {
                if (p == null || p.list[c - 'a'] == null)
                    return res;
                else {
                    p = p.list[c - 'a'];
                    res++;
                }
            }
            return res;
        }

        void insert(String tar) {

            Trie p = this;
            for (char c : tar.toCharArray()) {

                if (p.list[c - 'a'] != null) {
                    p = p.list[c - 'a'];
                } else {
                    Trie node = new Trie();
                    p.list[c - 'a'] = node;
                    p = node;
                }

            }
        }

    }

    public static void main(String[] args) {

        _3291Solution so = new _3291Solution();
        String[] words = { "abc", "aaaaa", "bcdef" };
        so.minValidStrings(words, "aabcdabc");
    }
}
