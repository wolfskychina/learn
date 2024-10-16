package leetcode.a1000;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 能向8个相邻方向移动的最短路径
 * {bfs}
 */
public class _1091Solution {

    private static int[][] move = { { -1, 0 }, { -1, 1 }, { -1, -1 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { 1, -1 },
            { 1, 1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {

        Set<Integer> set = new HashSet<>();
        int step = 1;
        if (grid[0][0] == 1)
            return -1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 0, 0 });

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {

                int[] node = q.poll();
                if (set.contains(node[0]*100+node[1]))
                    continue;
                if (node[0] == grid.length - 1 && node[1] == grid[0].length - 1)
                    return step;
                set.add(node[0]*100+node[1]);
                for (int j = 0; j < 8; j++) {
                    int xx = node[0] + move[j][0];
                    int yy = node[1] + move[j][1];
                    if (valid(grid, xx, yy))
                        q.offer(new int[] { xx, yy });
                }
            }
            step++;

        }

        return -1;
    }

    private boolean valid(int[][] grid, int x, int y) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 1)
            return false;
        return true;
    }

    public static void main(String[] args){

        _1091Solution so = new _1091Solution();
        int[][] grid = {{0,0,0},{1,1,0},{1,1,1}};
        so.shortestPathBinaryMatrix(grid);
    }
}
