package leetcode.a1000;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 按照离起始点的距离顺序对单元格进行排序
 */
public class _1030Solution {
   
    private static int[][] step = {{0,1},{1,0},{0,-1},{-1,0}};

    /**
     * {bfs}超时了
     * @param rows
     * @param cols
     * @param rCenter
     * @param cCenter
     * @return
     */
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {

        int matrix[][] = new int[rows][cols];
        //Set<Integer> set = new HashSet<>();
        //set.add(rCenter*100+cCenter);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{rCenter,cCenter});
        int dis=1;
        int res[][] = new int[rows*cols][2];
        int k=0;
     
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){

                int[] p = queue.poll();
                if( matrix[p[0]][p[1]]==0)
                {
                    res[k][0] = p[0];
                    res[k++][1] = p[1];
                }

                matrix[p[0]][p[1]] = dis;
                for(int j=0;j<4;j++){
                    int xx = p[0]+step[j][0];
                    int yy= p[1]+step[j][1];
                    if(valid(xx,yy,rows,cols,matrix)){
                        queue.offer(new int[]{xx,yy});
                    }
                }
            }
        }

        return res;

    }

    private boolean valid(int x,int y,int row,int col,int[][] matrix){

        return x>=0&&x<row&&y>=0&&y<col&&matrix[x][y]==0;
    }

    /**
     * {bucked sorting}桶排序
     */
    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        int[][] re = new int[R * C][2];
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        ArrayList<LinkedList<Pos>> bucket = new ArrayList<>(maxDist + 1);
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new LinkedList<>());
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = dist(i, j, r0, c0);
                LinkedList<Pos> list = bucket.get(d);
                list.add(new Pos(i,j));
            }
        }
        int cnt = 0;
        for (int i = 0; i <= maxDist; i++) {
            LinkedList<Pos> list = bucket.get(i);
            if (list.isEmpty()) continue;
            for (Pos p : list) {
                re[cnt][0] = p.r;
                re[cnt][1] = p.c;
                cnt++;
            }
        }

        return re;
    }

    private int dist(int r1,int c1,int r2,int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    private static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
