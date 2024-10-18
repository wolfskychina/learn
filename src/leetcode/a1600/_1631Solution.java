package leetcode.a1600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 从左上到右下的最小代价距离
 * 最小代价指路径上相邻节点差的绝对值的最大值
 */
public class _1631Solution {

    /**
     * {matrix},{union-find},{TODO}
     * @param mat
     * @return
     */
    public int minimumEffortPath(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    edges.add(new int[] {
                            Math.abs(mat[i][j + 1] - mat[i][j]),
                            i * N + j,
                            i * N + j + 1
                    });
                }
                if (i + 1 < M) {
                    edges.add(new int[] {
                            Math.abs(mat[i + 1][j] - mat[i][j]),
                            i * N + j,
                            (i + 1) * N + j
                    });
                }
            }
        }
        Collections.sort(edges, (o1, o2) -> o1[0] - o2[0]);

        UnionFind uf = new UnionFind(M * N);
        for (int[] edge : edges) {
            uf.union(edge[1], edge[2]);
            if (uf.find(0) == uf.find(M * N - 1)) {
                return edge[0];
            }
        }
        return 0;
    }

    class UnionFind {
        int count; // 连通分量个数
        int[] parent; // 节点i的父节点是parent[i]

        public UnionFind(int N) {
            this.count = N; // n为图的节点总数
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i; // 父节点指针初始指向自己
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY; // x成为y的子树
            count--;
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
