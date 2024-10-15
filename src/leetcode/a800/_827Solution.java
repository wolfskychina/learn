package leetcode.a800;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 在矩阵上填一个空格能连接成的最大岛屿
 * 
 * {matrix},{bfs}
 */
public class _827Solution {

    private static final int[][] DIRS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    /**
     * 遍历每个空格点
     * @param grid
     * @return
     */
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        List<Integer> area = new ArrayList<>();
        // DFS 每个岛，统计各个岛的面积，记录到 area 列表中
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    area.add(dfs(grid, i, j, area.size() + 2));
                }
            }
        }

        // 特判没有岛的情况
        if (area.isEmpty()) {
            return 1;
        }

        int ans = 0;
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
                s.clear();
                int newArea = 1;
                for (int[] dir : DIRS) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (0 <= x && x < n && 0 <= y && y < n && grid[x][y] != 0 && s.add(grid[x][y])) {
                        newArea += area.get(grid[x][y] - 2); // 累加面积
                    }
                }
                ans = Math.max(ans, newArea);
            }
        }

        // 如果最后 ans 仍然为 0，说明所有格子都是 1，返回 n^2
        return ans == 0 ? n * n : ans;
    }

    private int dfs(int[][] grid, int i, int j, int id) {
        grid[i][j] = id; // 记录 (i,j) 属于哪个岛
        int size = 1;
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            // 一个空格点可能连接不止两块岛屿，最多能连接4个
            // 但是有可能不同方向上是同一个岛屿
            if (0 <= x && x < grid.length && 0 <= y && y < grid.length && grid[x][y] == 1) {
                size += dfs(grid, x, y, id);
            }
        }
        return size;
    }
}
