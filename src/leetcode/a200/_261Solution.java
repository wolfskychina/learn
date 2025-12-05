package leetcode.a200;

/**
 * 判断一个由一系列边表示的无向图是不是一颗树
 * {graph},{union find}
 */
public class _261Solution {
    /**
     * 一个无向图是一个合格的树的条件:
     * 图中没有环路
     * 图是全联通的
     * 
     * 使用union-find方法
     */
    public boolean validTree(int n, int[][] edges) {
        if (n <= 1)
            return true;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if (x == y)
                return false;
            parent[y] = x;
        }

        return edges.length == n - 1;
    }

    public int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}
