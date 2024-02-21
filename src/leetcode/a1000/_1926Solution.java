package leetcode.a1000;

import java.util.ArrayDeque;
import java.util.Queue;
/**
 * 迷宫中离起始点最近的出口
 * {bfs}
 */
public class _1926Solution {
    private static int[][] step = {{1,0},{-1,0},{0,1},{0,-1}};
    public int nearestExit(char[][] maze, int[] entrance) {

        maze[entrance[0]][entrance[1]] = '+';

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int count =0;
        
        for(int i=0;i<4;i++){
            int x = entrance[0]+step[i][0];
            int y = entrance[1]+step[i][1];
            if(valid(x,y,maze)){
                int [] node = {x,y};
                visited[x][y]=true;
                q.add(node);
            }
        }
        count++;

        while(!q.isEmpty()){

            int size = q.size();
            for(int i=0;i<size;i++){
                int [] node = q.poll();
                if(node[0]==0||node[0]==maze.length-1||
                node[1]==0||node[1]==maze[0].length-1){
                    return count;
                }
                for(int j=0;j<4;j++){
                    int x = node[0]+step[j][0];
                    int y = node[1]+step[j][1];
                    int [] newnode = {x,y};

                    if(valid(x,y,maze)&&!visited[x][y]){
                        visited[x][y]=true;
                        q.add(newnode);
                    }
                }
            }
            count++;
        }

        return -1;
    }
    private boolean valid(int x, int y,char[][] maze) {

        return x>=0&&x<maze.length&&y>=0&&y<maze[0].length&&maze[x][y]=='.';
    }
}
