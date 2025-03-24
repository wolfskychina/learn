package leetcode.a1200;

/**
 * 得分最高的单词集合
 * 每个字母分数不同，出现的次数有限制
 * 问从单词组里面选一些单词，字符总的出现次数不超过letters
 * 能够得到的最大分数
 * {backtrace},{dfs}
 */
public class _1255Solution {

    private String[] words;
    private int[] score, left = new int[26];
    private int ans;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        this.score = score;
        for (char c : letters)
            ++left[c - 'a'];
        dfs(words.length - 1, 0);
        return ans;
    }

    private void dfs(int i, int total) {
        if (i < 0) { // base case
            ans = Math.max(ans, total);
            return;
        }

        // 不选 words[i]
        dfs(i - 1, total);

        // 选 words[i]
        char[] s = words[i].toCharArray();
        boolean ok = true;
        for (char c : s) {
            if (left[c - 'a']-- == 0)
                ok = false; // 剩余字母不足
            total += score[c - 'a']; // 累加得分
        }

        if (ok)
            dfs(i - 1, total);

        // 恢复现场
        for (char c : s)
            ++left[c - 'a'];
    }
}
