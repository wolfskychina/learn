package leetcode.a800;

import java.util.HashMap;
import java.util.Map;

/**
 * 不同的路径的数量
 * 要求路径覆盖所有能走的格子，并且不能重复走之前已经访问过的格子
 */
public class _980Solution {

    /**
     * {backtrace}
     * 先统计可以走的格子的数量，然后直接回溯查找
     * @param grid
     * @return
     */
    public int uniquePathsIII(int[][] grid) {
        int cnt0 = 0, sx = -1, sy = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0)
                    cnt0++;
                else if (grid[i][j] == 1) { // 起点
                    sx = i;
                    sy = j;
                }
            }
        }
        return dfs(grid, sx, sy, cnt0 + 1); // +1 把起点也算上
    }

    private int dfs(int[][] grid, int x, int y, int left) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] < 0)
            return 0; // 不合法
        if (grid[x][y] == 2) // 到达终点
            return left == 0 ? 1 : 0; // 必须访问所有的无障碍方格
        grid[x][y] = -1; // 标记成访问过，因为题目要求「不能重复通过同一个方格」
        int ans = dfs(grid, x - 1, y, left - 1) + dfs(grid, x, y - 1, left - 1) +
                dfs(grid, x + 1, y, left - 1) + dfs(grid, x, y + 1, left - 1);
        grid[x][y] = 0; // 恢复现场
        return ans;
    }


    private Map<Integer, Integer> memo = new HashMap<>();

    /**
     * 状态压缩和记忆化搜索的解法
     * @param grid
     * @return
     */
    public int uniquePathsIII2(int[][] grid) {
        int n = grid[0].length, vis = 0, sx = -1, sy = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) // 把障碍方格算上
                    vis |= 1 << (i * n + j);
                else if (grid[i][j] == 1) { // 起点
                    sx = i;
                    sy = j;
                }
            }
        }
        return dfs1(grid, sx, sy, vis);
    }

    private int dfs1(int[][] grid, int x, int y, int vis) {
        int m = grid.length, n = grid[0].length;
        int p = x * n + y;
        if (x < 0 || x >= m || y < 0 || y >= n || (vis >> p & 1) > 0)
            return 0; // 不合法
        vis |= 1 << p; // 标记访问过 (x,y)，因为题目要求「不能重复通过同一个方格」
        if (grid[x][y] == 2) // 到达终点
            return vis == (1 << m * n) - 1 ? 1 : 0; // 必须访问所有的无障碍方格
        int key = (p << m * n) | vis; // 把参数压缩成一个整数（左移 m*n 是因为 vis 至多有 m*n 个比特）
        if (memo.containsKey(key)) return memo.get(key); // 之前算过
        int ans = dfs(grid, x - 1, y, vis) + dfs(grid, x, y - 1, vis) +
                  dfs(grid, x + 1, y, vis) + dfs(grid, x, y + 1, vis);
        memo.put(key, ans);
        return ans;
    }

}
