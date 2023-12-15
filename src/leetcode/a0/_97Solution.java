package leetcode.a0;

import java.util.ArrayDeque;
import java.util.Queue;

public class _97Solution {

    /**
     * {backtrace} 回溯方法超时了
     * 
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {

        // s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] str3 = s3.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3)
            return false;
        if (s1.isEmpty() && s2.equals(s3))
            return true;
        if (s2.isEmpty() && s1.equals(s3))
            return true;

        return dfs(0, 0, 0, len1, len2, len3, str1, str2, str3);

    }

    private boolean dfs(int i, int j, int k, int len1, int len2, int len3, char[] s1, char[] s2, char[] s3) {
        if (k == len3 - 1) {
            if (i == len1 - 1 && s3[len3 - 1] == s1[i]) {
                return true;
            }
            if (j == len2 - 1 && s3[len3 - 1] == s2[j]) {
                return true;
            }
            return false;
        }

        if (i <= len1 - 1 && s1[i] == s3[k]) {
            if (dfs(i + 1, j, k + 1, len1, len2, len3, s1, s2, s3))
                return true;
        }

        if (j <= len2 - 1 && s2[j] == s3[k]) {
            if (dfs(i, j + 1, k + 1, len1, len2, len3, s1, s2, s3))
                return true;
        }

        return false;
    }

    /**
     * 改为按照s3逐个字符进行迭代，用队列保存上一轮可行结果
     * {dp}还是超时
     */
    public boolean isInterleave1(String s1, String s2, String s3) {

        // s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] str3 = s3.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3)
            return false;
        if (s1.isEmpty() && s2.equals(s3))
            return true;
        if (s2.isEmpty() && s1.equals(s3))
            return true;

        int i = 0;
        int j = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { i, j });
        for (int k = 0; k < len3; k++) {
            int size = q.size();
            if (size == 0)
                return false;
            for (int times = 0; times < size; times++) {
                int[] po = q.poll();
                int ii = po[0];
                int jj = po[1];
                if (ii < len1 && str1[ii] == str3[k])
                    q.offer(new int[] { ii + 1, jj });
                if (jj < len2 && str2[jj] == str3[k])
                    q.offer(new int[] { ii, jj + 1 });
            }
        }
        return !q.isEmpty();

    }

    /**
     * {dp} 定义f[i][j]为s1(0,i]和s2(0,j]能否组成s3[0,i+j]
     * 从f[i-1][j]和f[i][j-1]能够推断出f[i][j]
     * TODO
     * @return
     */
    public boolean isInterleave2(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];
    }

    public static void main(String[] args) {
        _97Solution so = new _97Solution();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        so.isInterleave1(s1, s2, s3);
    }
}
