package leetcode.a300;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求一个矩阵中，空格到最近的门的距离
 */
public class _286Solution {


    private final static int INF = 2147483647;
    private final static int GATE = 0;
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * 多点bfs
     * @param rooms
     */
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == GATE){
                    queue.add(new int[] {i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0], y = point[1];

            for(int[] dir : dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(newX < 0 || newX >= m || newY < 0 || newY >= n 
                        || rooms[newX][newY] != INF)
                    continue;
                rooms[newX][newY] = rooms[x][y] + 1;
                queue.add(new int[] {newX, newY});
            }
        }

    }

}
