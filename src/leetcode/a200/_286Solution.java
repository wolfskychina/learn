package leetcode.a200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求一个矩阵中，空格到最近的门的距离
 * {bfs},{dfs}
 */
public class _286Solution {

    private final static int INF = 2147483647;
    private final static int GATE = 0;
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    /**
     * 多点bfs
     * 
     * @param rooms
     */
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    // 多点bfs，初始的时候队列中有多个元素
                    queue.add(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];

            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n
                        || rooms[newX][newY] != INF)
                    continue;
                rooms[newX][newY] = rooms[x][y] + 1;
                queue.add(new int[] { newX, newY });
            }
        }

    }

    /**
     * dfs ，测试时更快
     * @param rooms
     */
    public void wallsAndGates1(int[][] rooms) {
        if(rooms==null || rooms.length==0||rooms[0].length==0)
            return;
     
        int m = rooms.length;
        int n = rooms[0].length;
     
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j]==0){
                    fill(rooms, i, j, 0);
                }
            }
        }
    }
     
    public void fill(int[][] rooms, int i, int j, int distance){
        int m=rooms.length;
        int n=rooms[0].length;
     
        if(i<0||i>=m||j<0||j>=n||rooms[i][j]<distance){
            return;
        }
     
        rooms[i][j] = distance;
     
        fill(rooms, i-1, j, distance+1);
        fill(rooms, i, j+1, distance+1);
        fill(rooms, i+1, j, distance+1);
        fill(rooms, i, j-1, distance+1);
    }

}
