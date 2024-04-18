package leetcode.a200;

/**
 * 比较两个单词的最短距离
 * 两个单词可能相等，但是不是出现在同一个位置上，而是两个不同的位置
 * {greedy},{two pointers}
 * 符合贪心规则，不过两个单词相等时需要单独处理
 */
public class _245Solution {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
        boolean same = word1.equals(word2);
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                // 如果两个单词相等，这里要强制进行比较
                if (same) {
                    i1 = i2;
                    i2 = i;
                } else {
                    i1 = i;
                }
            } else if (words[i].equals(word2)) {
                i2 = i;
            }
            dist = Math.min(dist, Math.abs(i1 - i2));
        }
        return (int) dist;
    }
}
