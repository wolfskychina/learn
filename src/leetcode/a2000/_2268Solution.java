package leetcode.a2000;

import java.util.Arrays;

/**
 * 最少的按键数量
 * 同3016题
 * {greedy}
 */
public class _2268Solution {

    public int minimumKeypresses(String s) {
        int[] cnt = new int[26];
        for (char b : s.toCharArray()) {
            cnt[b - 'a']++;
        }
        Arrays.sort(cnt);

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += cnt[25 - i] * (i / 9 + 1);
        }
        return ans;
    }
}
