package leetcode.a3000;

import java.util.Arrays;

/**
 * 字符串能够拆成由同一个子串的各种变形词拼接而成
 * 这样的子串最小长度是多少
 * {counting}
 */
public class _3138Solution {

    /**
     * 因为s的长度最多为100000，因子不超过128个
     * 所以直接对所有可能情况遍历即可
     * 
     * @param S
     * @return
     */
    public int minAnagramLength(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        next: for (int k = 1; k <= n / 2; k++) {
            if (n % k > 0) {
                continue;
            }
            int[] cnt0 = new int[26];
            for (int j = 0; j < k; j++) {
                cnt0[s[j] - 'a']++;
            }
            for (int i = k * 2; i <= n; i += k) {
                int[] cnt = new int[26];
                for (int j = i - k; j < i; j++) {
                    cnt[s[j] - 'a']++;
                }
                if (!Arrays.equals(cnt, cnt0)) {
                    continue next;
                }
            }
            return k;
        }
        return n;
    }
}
