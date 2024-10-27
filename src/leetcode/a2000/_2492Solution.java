package leetcode.a2000;


/**
 * 加权无向图中节点1-n的所有路径中权值最小的值
 * 这里定义的路径权值是路径中value最小的边的值
 * 路径可以重复经过任何节点
 * 实际上是求1-n的联通分量中的最小边
 * 已知1-n肯定是相连的
 * {graph},{union-find} 
 */
public class _2492Solution {

    public int minScore(int n, int[][] roads) {

        UnionFind un = new UnionFind(n);

        for (int[] r : roads) {
            un.union(r[0] - 1, r[1] - 1, r[2]);
        }

        return un.min[un.find(0)];

    }

    private class UnionFind {

        int parent[];
        int min[];

        public UnionFind(int n) {
            parent = new int[n];
            min = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                min[i] = Integer.MAX_VALUE;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y, int value) {

            int px = find(x);
            int py = find(y);
            if (px == py) {
                min[px] = Math.min(min[px], value);
            } else {
                min[py] = Math.min(value, Math.min(min[px], min[py]));
                parent[px] = py;
            }
        }
    }
}
