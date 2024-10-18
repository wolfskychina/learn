package leetcode.a1100;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 地图中的最高点
 * 海平面高度为0，相邻节点差值最多为1，能够形成的最高点
 * {matrix},{bfs}
 */
public class _1765Solution {

    /**
     * 多源点bfs
     * @param isWater
     * @return
     */
    public int[][] highestPeak(int[][] isWater) {

        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {

                if (isWater[i][j] == 0)
                    isWater[i][j] = 2;
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        boolean visited[][] = new boolean[isWater.length][isWater[0].length];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {

                if (isWater[i][j] == 1) {
                    isWater[i][j] = 0;
                    q.offer(new int[] { i, j });
                    visited[i][j] = true;
                }
                if (isWater[i][j] == 2)
                    isWater[i][j] = 1;
            }
        }

        int level = 0;
        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] n = q.poll();
                // if(visited[n[0]][n[1]]) continue;
                isWater[n[0]][n[1]] = level;
                for (int j = 0; j < 4; j++) {
                    int x = n[0] + step[j][0];
                    int y = n[1] + step[j][1];
                    if (!valid(isWater, x, y, visited))
                        continue;
                    visited[x][y] = true;
                    q.offer(new int[] { x, y });

                }

            }
            level++;
        }

        return isWater;

    }

    private static int[][] step = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private boolean valid(int[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y])
            return false;
        return true;
    }
}
