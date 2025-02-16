package leetcode.a3000;

import java.util.Arrays;

/**
 * 重新映射字符后，输入单词所需要的最少按键次数
 * {greedy}
 */
public class _3016Solution {

    public int minimumPushes(String word) {
        int[] cnt = new int[26];
        for (char b : word.toCharArray()) {
            cnt[b - 'a']++;
        }
        Arrays.sort(cnt);

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += cnt[25 - i] * (i / 8 + 1);
        }
        return ans;
    }
}
