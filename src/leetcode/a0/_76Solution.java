package leetcode.a0;

import java.util.HashMap;
import java.util.Map;

/**
 * t是模式串，问s中能够覆盖t中出现的所有字符（字符可能有重复）的最小子串
 * {two pointers}
 */
public class _76Solution {

    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired
        // window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current
        // window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        int[] ans = { -1, 0, 0 };

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).equals(dictT.get(c))) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    // 这时候c的数量不足了
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    /**
     * 另外一种更快的方法
     * @param s
     * @param t
     * @return
     */
    public String minWindow1(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if (len1 < len2) {
            return "";
        }
        int[] sArr = new int[128];
        int[] tArr = new int[128];
        int tKind = 0;
        for (char c : t.toCharArray()) {
            if (tArr[c]++ == 0) {
                tKind++;
            }
        }
        int ansL = -1, ansR = len1;
        int l = 0, r = 0;
        for (; r < len1; r++) {
            char cur = s.charAt(r);
            if (++sArr[cur] == tArr[cur]) {
                tKind--;
            }
            while (tKind == 0) {
                if (r - l < ansR - ansL) {
                    ansL = l;
                    ansR = r;
                }
                char x = s.charAt(l++);
                if (sArr[x]-- == tArr[x]) {
                    tKind++;
                }
            }
        }
        return ansL < 0 ? "" : s.substring(ansL, ansR + 1);
    }
}
