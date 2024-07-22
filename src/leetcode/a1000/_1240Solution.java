package leetcode.a1000;

/**
 * 铺瓷砖，一块m*n的空间最少能用多少块正方形瓷砖填满
 */
public class _1240Solution {

    int ans;

    /**
     * 背包填充问题
     * 难点是疑似是np问题，也不能用贪心做
     * 最基本的回溯进行暴力搜索
     * {backtrace},TODO
     * 
     * @param n
     * @param m
     * @return
     */
    public int tilingRectangle(int n, int m) {
        ans = Math.max(n, m);
        boolean[][] rect = new boolean[n][m];
        dfs(0, 0, rect, 0);
        return ans;
    }

    public void dfs(int x, int y, boolean[][] rect, int cnt) {
        int n = rect.length, m = rect[0].length;
        if (cnt >= ans) {
            return;
        }
        if (x >= n) {
            ans = cnt;
            return;
        }
        /* 检测下一行 */
        if (y >= m) {
            dfs(x + 1, 0, rect, cnt);
            return;
        }
        /* 如当前已经被覆盖，则直接尝试下一个位置 */
        if (rect[x][y]) {
            dfs(x, y + 1, rect, cnt);
            return;
        }

        int len = Math.min(n - x, m - y);
        while (len >= 1 && !isAvailable(rect, x, y, len)) {
            len--;
        }
        for (int k = len; k >= 1; k--) {
            // 从大到小，尽可能用大的瓷砖覆盖
            /* 将长度为 k 的正方形区域标记覆盖 */
            fillUp(rect, x, y, k, true);
            /* 跳过 k 个位置开始检测 */
            dfs(x, y + k, rect, cnt + 1);
            fillUp(rect, x, y, k, false);
        }
    }

    public boolean isAvailable(boolean[][] rect, int x, int y, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rect[x + i][y + j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void fillUp(boolean[][] rect, int x, int y, int k, boolean val) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                rect[x + i][y + j] = val;
            }
        }
    }
}
