package leetcode.a2000;
/**
 * 字符串及其反转中是否存在同一两位的子串
 * {bit count}
 */
public class _3083Solution {

    public boolean isSubstringPresent(String S) {
        char[] s = S.toCharArray();
        boolean[][] vis = new boolean[26][26];
        for (int i = 1; i < s.length; i++) {
            int x = s[i - 1] - 'a';
            int y = s[i] - 'a';
            vis[x][y] = true;
            if (vis[y][x]) {
                return true;
            }
        }
        return false;
    }

    public boolean isSubstringPresent1(String s) {
        int[] vis = new int[26];
        for (int i = 1; i < s.length(); ++i) {
            int x = s.charAt(i) - 'a';
            int y = s.charAt(i - 1) - 'a';
            // 巧妙的位操作
            vis[x] |= 1 << y;
            if ((vis[y] >> x & 1) == 1) {
                return true;
            }
        }
        return false;

    }
}
