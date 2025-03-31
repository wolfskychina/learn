package leetcode.a1000;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串的最长重复子串
 * {binary search},{string hash}
 */
public class _1062Solution {

    long[] h, p;

    public int longestRepeatingSubstring(String s) {
        int P = 1313131, n = s.length();
        h = new long[n + 10];
        p = new long[n + 10];
        p[0] = 1;
        // rolling hash 预先计算rollinghash的值
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + s.charAt(i);
        }
        int ans = 0;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            String t = check(s, mid);
            if (t.length() != 0)
                l = mid;
            else
                r = mid - 1;
            ans = Math.max(ans, t.length());
        }
        return ans;
    }

    String check(String s, int len) {
        int n = s.length();
        Set<Long> set = new HashSet<>();
        for (int i = 0; i + len -1< n; i++) {
            int j = i + len;
            // 因为知道起止位置，可以通过一次计算得到子串的hash值
            long cur = h[j] - h[i] * p[len];
            if (set.contains(cur))
                return s.substring(i, j);
            set.add(cur);
        }
        return "";
    }
}
