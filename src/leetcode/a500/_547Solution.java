package leetcode.a500;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找到无向矩阵中省的数量
 * 所有能够相连的点算一个省
 */
public class _547Solution {

    /**
     * {bfs},{queue},{graph}
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

    /**
     * {union find} 并查集的解法
     * @param isConnected
     * @return
     */
    public int findCircleNum3(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            // 在查找的同时，有一个拉平的操作
            parent[index] = find(parent, parent[index]);
        }
        // 不能返回index因为index没变，而parent[index]因为递归
        // 可能拉平，所以可能会变成新的根节点
        return parent[index];
    }
}
