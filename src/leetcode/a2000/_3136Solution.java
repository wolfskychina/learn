package leetcode.a2000;

import java.util.Arrays;

/**
 * 判断一个单词是否是valid的
 * {easy},{Character}
 */
public class _3136Solution {
   
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        boolean[] f = new boolean[2];
        Arrays.fill(f, false);
        for (char c : word.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                c = Character.toLowerCase(c);
                f[c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0] = true;
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return f[0] && f[1];
    }
}
