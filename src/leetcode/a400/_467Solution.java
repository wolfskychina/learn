package leetcode.a400;

import java.util.Arrays;
/**
 * p中有多少个子串，这些子串同时也是abcd...xyzabcd...xyz...无限循环字符串
 * 的子串？
 */
public class _467Solution {

    /**
     * dp建模，dp[i]定义为以第i个字母为结尾的连续子串的最大长度
     * 只需要一趟扫描就能获取到所有字母的dp[]最大长度
     * @param p
     * @return
     */
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        char[] array = p.toCharArray();
        for (int i = 0; i < array.length; ++i) {
            if (i > 0 && (array[i] - array[i-1] + 26) % 26 == 1) { // 字符之差为 1 或 -25
                ++k;
            } else {
                k = 1;
            }
            dp[array[i] - 'a'] = Math.max(dp[array[i] - 'a'], k);
        }
        return Arrays.stream(dp).sum();
    }

}
