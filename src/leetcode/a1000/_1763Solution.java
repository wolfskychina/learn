package leetcode.a1000;

/**
 * 最长的美好字符串
 */
public class _1763Solution {
   
    /**
     * {prefix sum}
     * @param s
     * @return
     */
    public String longestNiceSubstring(String s) {
        int n = s.length();
        int[][] cnt = new int[n + 1][128];
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            cnt[i] = cnt[i - 1].clone();
            cnt[i][c - 'A']++;
        }
        int idx = -1, len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 <= len) continue;
                int[] a = cnt[i], b = cnt[j + 1];
                if (check(a, b)) {
                    idx = i; len = j - i + 1;
                }
            }
        }
        return idx == -1 ? "" : s.substring(idx, idx + len);
    }

    boolean check(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            int low = b[i] - a[i], up = b[i + 32] - a[i + 32]; // 'A' = 65、'a' = 97
            if (low != 0 && up == 0) return false;
            if (low == 0 && up != 0) return false;
        }
        return true;
    }
}
