package leetcode.a2000;

/**
 * 统计图中完全联通分量的数量
 * 完全连通分量是指任意两个点都直接相连的联通分量
 * {graph}
 */
public class _2685Solution {

    /**
     * 统计每堆的节点数量和边的数量
     * {union-find}
     * @param n
     * @param edges
     * @return
     */
    public int countCompleteComponents(int n, int[][] edges) {
        // union-find分堆，每堆的节点数量统计
        Union un = new Union(n);
        for (int[] e : edges) {
            un.union(e[0], e[1]);
        }

        // 总对数量-联通分量内部节点对数量即可
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = un.find(i);
            if (x == i && un.numE[x] == (un.numV[x] - 1) * un.numV[x] / 2)
                res++;

        }
        return res;

    }

    private class Union {

        int parent[];
        int numV[];
        int numE[];

        public Union(int n) {
            parent = new int[n];
            numV = new int[n];
            numE = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                numV[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {

            int rx = find(x), ry = find(y);
            if (rx != ry) {
                if (numV[rx] > numV[ry]) {
                    parent[ry] = rx;
                    numV[rx] += numV[ry];
                    numE[rx] += numE[ry] + 1;
                } else {
                    parent[rx] = ry;
                    numV[ry] += numV[rx];
                    numE[ry] += numE[rx] + 1;
                }
            } else {
                numE[rx]++;
            }

        }
    }
}
