package leetcode.a3000;

import java.util.Arrays;

/**
 * 使字符串中任意字符出现的次数的差不超过k所需要删除的最少字符
 * {greedy},{counting},{sort}
 */
public class _3085Solution {

    public int minimumDeletions(String word, int k) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        Arrays.sort(cnt);

        int maxSave = 0;
        for (int i = 0; i < 26; i++) {
            int sum = 0;
            // 遍历i为出现次数最少的情况
            for (int j = i; j < 26; j++) {
                sum += Math.min(cnt[j], cnt[i] + k); // 至多保留 cnt[i]+k 个
            }
            maxSave = Math.max(maxSave, sum);
        }
        return word.length() - maxSave;
    }
}
