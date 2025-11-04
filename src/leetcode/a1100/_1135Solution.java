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
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);

        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; ++i)
            parent[i] = i;

        int cost = 0;
        int edgesAdded = 0; // 新增：统计成功合并的边数
        for (int[] edge : connections) {
            if (union(edge[0], edge[1], parent)) {
                cost += edge[2];
                edgesAdded++;
                // 优化：合并边数达到N-1时，已形成MST，提前退出
                if (edgesAdded == N - 1) 
                    break;
            }
        }

        // 优化：直接通过边数判断是否连通（无需遍历所有节点）
        return edgesAdded == N - 1 ? cost : -1;
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
