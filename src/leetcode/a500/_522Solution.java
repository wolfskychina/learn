package leetcode.a500;
/**
 * 字符串数组，求这个数组中字符串的最长特异子序列
 * {lcs},{subsequence}
 */
public class _522Solution {

    /**
     * 如果某个strs[i]的一个子序列是特异子序列
     * 那么strs[i]本身也是特异子序列
     * 所以可以找到所有strs[i]是其他字符串特异子序列的情况
     * 其中最长的strs[i]的长度就是最长特异子序列的长度
     * @param strs
     * @return
     */
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            boolean check = true;
            for (int j = 0; j < n; ++j) {
                if (i != j && isSubseq(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    public boolean isSubseq(String s, String t) {
        int ptS = 0, ptT = 0;
        while (ptS < s.length() && ptT < t.length()) {
            if (s.charAt(ptS) == t.charAt(ptT)) {
                ++ptS;
            }
            ++ptT;
        }
        return ptS == s.length();
    }
}
