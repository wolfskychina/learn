package leetcode.a1000;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长的重复子串
 * 跟187类似，187是定长重复子串，这个是最长重复子串
 * 因为长的重复子串必然包含更短的重复子串，所以可以用二分搜索来解
 * {binary search},{string hash}
 * 
 */
public class _1044Solution {

    long[] h, p;

    public String longestDupSubstring(String s) {
        int P = 1313131, n = s.length();
        h = new long[n + 10];
        p = new long[n + 10];
        p[0] = 1;
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + s.charAt(i);
        }
        String ans = "";
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            String t = check(s, mid);
            if (t.length() != 0)
                l = mid;
            else
                r = mid - 1;
            ans = t.length() > ans.length() ? t : ans;
        }
        return ans;
    }

    String check(String s, int len) {
        int n = s.length();
        Set<Long> set = new HashSet<>();
        for (int i = 1; i + len - 1 <= n; i++) {
            int j = i + len - 1;
            long cur = h[j] - h[i - 1] * p[j - i + 1];
            if (set.contains(cur))
                return s.substring(i - 1, j);
            set.add(cur);
        }
        return "";
    }
}
