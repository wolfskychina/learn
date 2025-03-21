package leetcode.a1800;

/**
 * 字符串能否拆分为递减1的连续数字
 * {backtrace},{dfs}
 */
public class _1849Solution {

    char[] num;
    int n;

    public boolean splitString(String s) {
        n = s.length();
        num = s.toCharArray();
        return dfs(0, 0, 0);
    }

    private boolean dfs(int index, long prev, int cnt) {
        if (index == n) {
            return cnt > 1;
        }
        long cur = 0;
        for (int i = index; i < n; i++) {
            cur = cur * 10 + num[i] - '0';
            if (cnt == 0 || cur == prev - 1) {
                if (dfs(i + 1, cur, cnt + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
