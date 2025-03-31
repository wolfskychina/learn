package leetcode.a1100;

import java.util.Arrays;

/**
 * 加权无向图中连接所有点的最小开销
 * {graph},{union-find}
 */
public class _1135Solution {

    /**
     * 简单的union-find问题
     * @param N
     * @param connections
     * @return
     */
    public int minimumCost(int N, int[][] connections) {
        // sort connections by cost from small to large
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);

        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            parent[i] = i;
        }

        int cost = 0;
        for (int[] edge : connections) {
            if (union(edge[0], edge[1], parent)) {
                cost += edge[2];
            }
        }

        // System.out.println(Arrays.toString(parent));

        int p = -1;
        for (int i = 1; i <= N; ++i) {
            int root = findRoot(i, parent);
            if (p == -1) {
                p = root;
            } else if (p != root) {
                return -1;
            }
        }
        return cost;
    }

    public int findRoot(int x, int[] parent) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean union(int a, int b, int[] parent) {
        a = findRoot(a, parent);
        b = findRoot(b, parent);
        if (a == b)
            return false;
        parent[a] = b;
        return true;
    }
}
