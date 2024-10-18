package leetcode.a1900;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 迷宫中离起始点最近的出口
 * {bfs}
 */
public class _1926Solution {

    private static int[][] step = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int nearestExit(char[][] maze, int[] entrance) {

        maze[entrance[0]][entrance[1]] = '+';

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int count = 0;

        int x = entrance[0];
        int y = entrance[1];

        int[] node1 = { x, y };
        visited[x][y] = true;
        q.add(node1);

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                if (maze[node[0]][node[1]] != '+' && (node[0] == 0 || node[0] == maze.length - 1 || node[1] == 0
                        || node[1] == maze[0].length - 1)) {
                    return count;
                }
                for (int j = 0; j < 4; j++) {
                    int xx = node[0] + step[j][0];
                    int yy = node[1] + step[j][1];
                    int[] newnode = { xx, yy };

                    if (valid(xx, yy, maze) && !visited[xx][yy]) {
                        visited[xx][yy] = true;
                        q.add(newnode);
                    }
                }
            }
            count++;
        }

        return -1;
    }

    private boolean valid(int x, int y, char[][] maze) {

        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == '.';
    }

    public static void main(String[] args){

        _1926Solution so = new _1926Solution();

        char[][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = {1,2};

        so.nearestExit(maze, entrance);
    }
}
