package leetcode.a300;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 新增一个建筑，求这个建筑到其他所有建筑的最短路径之和
 * 曼哈顿距离
 * {bfs}
 */
public class _317Solution {
    int[] dx = new int[] { 1, 0, -1, 0 };
    int[] dy = new int[] { 0, -1, 0, 1 };

    /**
     * 多源bfs
     * 
     * @param grid
     * @return
     */
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // canReach[i][j]: count of buildings that can be reached from (i, j)
        int[][] canReach = new int[m][n];
        // dist[i][j]: accumulated distance from (i, j) to any building
        int[][] dist = new int[m][n];

        int totalBuildings = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    // 对每个building做BFS
                    if (!bfs(grid, i, j, dist, canReach))
                        return -1;
                }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 检查是否所有建筑都能到达 (i, j)
                if (canReach[i][j] == totalBuildings) {
                    minDistance = Math.min(minDistance, dist[i][j]);
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private boolean bfs(int[][] grid, int x, int y, int[][] dist, int[][] canReach) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { x, y });

        // 记录已经访问的地点
        visited[x][y] = true;

        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny] || grid[nx][ny] == 2) {
                        continue;
                    }
                    if (grid[nx][ny] == 0) {
                        dist[nx][ny] += steps;
                        canReach[nx][ny]++;
                        queue.offer(new int[] { nx, ny });
                    }
                    visited[nx][ny] = true;
                }
            }
            steps++;
        }
        // 提前终止条件，原图无解，避免最后再判断，解决时间
        // x,y节点本身无法到达某个其他的建筑节点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
