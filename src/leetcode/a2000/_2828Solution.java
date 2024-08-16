package leetcode.a2000;

import java.util.List;

/**
 * 首字母缩略词
 * {easy}
 */
public class _2828Solution {

    public boolean isAcronym(List<String> words, String s) {

        int n = s.length();
        if (words.size() != n) {
            return false;
        } else {
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != words.get(i).charAt(0)) {
                    return false;
                }
            }
            return true;
        }
    }
}
