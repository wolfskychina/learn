package leetcode.a2000;

import java.util.Arrays;

/**
 * 巡逻的骑士
 * 棋盘马走字游戏，一定有解
 * 暴力搜索
 * {backtrace}
 */
public class _2664Solution {
    int step[][] = { { 1, 2 }, { 1, -2 }, { -1, -2 }, { -1, 2 }, { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } };

    int res[][];
    boolean found = false;

    public int[][] tourOfKnight(int m, int n, int r, int c) {

        res = new int[m][n];
        for (int[] a : res) {
            Arrays.fill(a, -1);
        }
        dfs(r, c, m, n, 0);

        return res;

    }

    private void dfs(int r, int c, int m, int n, int idx) {

        if (found)
            return;

        res[r][c] = idx;

        if (idx == m * n) {
            found = true;
            return;
        }

        for (int i = 0; i < step.length; i++) {
            int rr = r + step[i][0];
            int cc = c + step[i][1];
            if (rr >= 0 && rr < m && cc >= 0 && cc < n && res[rr][cc] == -1) {
                dfs(rr, cc, m, n, idx + 1);
                if (found)
                    return;
            }
        }
        res[r][c] = -1;

    }

    public static void main(String[] args) {

        _2664Solution so = new _2664Solution();
        so.tourOfKnight(1, 1, 0, 0);
    }
}
