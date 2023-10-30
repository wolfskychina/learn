package leetcode.a500;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _505Solution {

    /**
     * dfs比较慢
     * 
     * @param maze
     * @param start
     * @param dest
     * @return
     */
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    public void dfs(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        for (int[] dir : dirs) {
            int x = start[0];
            int y = start[1];
            int count = 0;
            while (x + dir[0] >= 0 && y + dir[1] >= 0 && x + dir[0] < maze.length && y + dir[1] < maze[0].length
                    && maze[x + dir[0]][y + dir[1]] == 0) {
                x += dir[0];
                y += dir[1];
                count++;
            }
            if (distance[start[0]][start[1]] + count < distance[x][y]) {
                distance[x][y] = distance[start[0]][start[1]] + count;
                dfs(maze, new int[] { x, y }, distance);
            }
        }
    }

    /**
     * bfs算法，更快
     * 
     * @param maze
     * @param start
     * @param dest
     * @return
     */
    public int shortestDistance1(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            for (int[] dir : dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                    distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
                    queue.add(new int[] { x - dir[0], y - dir[1] });
                }
            }
        }
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }
}
