package leetcode.a500;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找到无向矩阵中省的数量
 * 所有能够相连的点算一个省
 */
public class _547Solution {

    /**
     * {bfs},{queue}
     * 
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {

        int m = isConnected.length;

        int res = 0;

        for (int i = 0; i < m; i++) {

            boolean ifpro = false;
            Queue<Integer> q = new LinkedList<>();
            for (int j = 0; j < m; j++) {
                if (isConnected[i][j] == 0 || isConnected[i][j] == 1) {

                    if (i != j && isConnected[i][j] == 1) {
                        q.add(j);
                    }
                    ifpro = true;
                    isConnected[i][j] = -1;
                    isConnected[j][i] = -1;
                }
            }
            while (!q.isEmpty()) {
                int x = q.poll();
                for (int y = 0; y < m; y++) {
                    if (isConnected[x][y] == 0 || isConnected[x][y] == 1) {
                        if (x != y && isConnected[x][y] == 1)
                            q.add(y);
                        isConnected[x][y] = -1;
                        isConnected[y][x] = -1;
                    }

                }
            }
            if (ifpro)
                res++;

        }

        return res;

    }

    /**
     * {dfs} 更快
     * @param isConnected
     * @return
     */
    public int findCircleNum1(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                dfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }

    public void dfs(int node, int[][] isConnected, boolean[] visit) {
        visit[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visit[i]) {
                dfs(i, isConnected, visit);
            }
        }
    }
}
