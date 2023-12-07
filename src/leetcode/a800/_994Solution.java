package leetcode.a800;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * grid里面有一些橘子，有的好，有的坏了，有的是空格
 * 每个回合坏橘子都会传染旁边的四个橘子
 * 求最多几个回合所有橘子都会腐烂，如果有橘子无法被传染，返回-1
 */
public class _994Solution {

    /**
     * 多点拓扑排序,bfs,记录每个橘子被传染回合的最小值
     * {bfs}
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {

        // 0 empty 1 good 2 bad
        // deal 1->1000 2->0
        List<int[]> start = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    grid[i][j] = 1000;
                } else if (grid[i][j] == 2) {
                    grid[i][j] = 0;
                    start.add(new int[] { i, j });
                }
            }
        }

        for (int[] s : start) {

            bfs(grid, s);
        }

        int max = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                max = Math.max(max,grid[i][j]);
            }
        }

        return max == 1000? -1:max;

    }

    private static int[][] step = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private void bfs(int[][] grid, int[] s) {

        int dept = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            dept++;
            int size = q.size();
            for (int k = 0; k <size; k++) {

                int[] start = q.poll();
                for (int i = 0; i < 4; i++) {
                    int x = start[0] + step[i][0];
                    int y = start[1] + step[i][1];
                    if (valid(x, y, grid, dept)) {
                        q.offer(new int[] { x, y });
                    }

                }
            }

        }

    }

    private boolean valid(int x, int y, int[][] grid, int dept) {
        if (x < 0 || x == grid.length || y < 0 || y == grid[0].length)
            return false;
        if (grid[x][y] ==0 ||grid[x][y] < dept)
            return false;
        grid[x][y] = dept;
        return true;
    }

    public static void main(String [] args){
        _994Solution so = new _994Solution();
        int[][] grid = {{2,1,1},{1,1,1},{0,1,2}};
        so.orangesRotting(grid);
    }
}
