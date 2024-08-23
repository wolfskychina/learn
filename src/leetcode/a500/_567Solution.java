package leetcode.a500;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 判断一个字符串是否有一种排列，是另外一个字符串的子串
 */
public class _567Solution {

    /**
     * {set},{map},{two pointers},{sliding window}
     * 使用HashMap和HashSet的双指针滑动窗口，比较慢
     * 
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> pattern = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int len = s1.length();
        for (char c : s1.toCharArray()) {
            pattern.put(c, pattern.getOrDefault(c, 0) + 1);
            set.add(c);
        }
        Map<Character, Integer> pattern1 = new HashMap<>();
        pattern1.putAll(pattern);
        int l = 0;
        int r = 0;
        while (l < s2.length() && r < s2.length()) {
            char c = s2.charAt(r);
            if (!set.contains(c)) {
                r++;
                l = r;
                pattern1.putAll(pattern);

            } else {
                if (pattern1.get(c) == 0) {
                    while (pattern1.get(c) == 0) {
                        pattern1.put(s2.charAt(l), pattern1.get(s2.charAt(l)) + 1);
                        l++;
                    }
                    r++;
                    pattern1.put(c, 0);

                } else {
                    pattern1.put(c, pattern1.get(c) - 1);
                    r++;
                    if (r - l == len)
                        return true;
                }
            }
        }

        return false;
    }

    /**
     * 只使用数组的滑动窗口，更快
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        int[] base = new int[26];
        for (int i = 0; i < n; i++) {
            base[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;
        int[] refer = new int[26];
        while (right < m) {
            int next = s2.charAt(right) - 'a';
            int len = right - left + 1;
            right++;
            if (base[next] == 0) {
                left = right;
                for (int i = 0; i < 26; i++) {
                    refer[i] = 0;
                }
                continue;
            }
            refer[next]++;

            if (n == len) {
                if (refer[next] == base[next]) {
                    return true;
                }
            }

            while (left <= right && refer[next] > base[next]) {
                int r = s2.charAt(left++) - 'a';
                refer[r]--;
            }
        }
        return false;
    }
}
