package leetcode.a500;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 0和1组成的矩阵
 * 更新格子的值为距离最近的0的距离
 * 
 */
public class _542Solution {

    int[][] step = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };

    /**
     * {bfs}
     * 但是速度比较慢
     * @param mat
     * @return
     */
    public int[][] updateMatrix(int[][] mat) {

        boolean visited[][] = new boolean[mat.length][mat[0].length];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                if (mat[i][j] != 0) {
                    mat[i][j] = 99999;
                    continue;
                }
                int node[] = { i, j };
                q.offer(node);

            }
        }

        int layer = 0;

        while (!q.isEmpty()) {
            int num = q.size();
            for (int s = 0; s < num; s++) {
                int[] node = q.poll();
                int i = node[0];
                int j = node[1];
                visited[i][j] = true;
                mat[i][j] =layer;

                for (int k = 0; k < 4; k++) {
                    int xx = i + step[k][0];
                    int yy = j + step[k][1];
                    if (xx >= 0 && xx < mat.length && yy >= 0 && yy < mat[0].length && !visited[xx][yy]) {
                        int n[] = { xx, yy };
                        q.offer(n);
                    }
                }
            }

            layer++;
        }

        return mat;
    }

    /**
     * bfs的优化，更新距离值的时候不需要比较大小，先访问的就是最小距离
     * @param mat
     * @return
     */
    public int[][] updateMatrix1(int[][] mat) {

        boolean visited[][] = new boolean[mat.length][mat[0].length];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                if (mat[i][j] != 0) {
                    //mat[i][j] = 99999;
                    continue;
                }
                int node[] = { i, j };
                visited[i][j] = true;
                q.offer(node);

            }
        }

        int layer = 0;

        while (!q.isEmpty()) {
            int num = q.size();
            for (int s = 0; s < num; s++) {
                int[] node = q.poll();
                int i = node[0];
                int j = node[1];
                mat[i][j] = layer;

                for (int k = 0; k < 4; k++) {
                    int xx = i + step[k][0];
                    int yy = j + step[k][1];
                    if (xx >= 0 && xx < mat.length && yy >= 0 && yy < mat[0].length && !visited[xx][yy]) {
                        int n[] = { xx, yy };
                        visited[xx][yy] = true;
                        q.offer(n);
                    }
                }
            }

            layer++;
        }

        return mat;
    }
    
}
