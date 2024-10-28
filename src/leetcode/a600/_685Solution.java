package leetcode.a600;

import java.util.Arrays;

/**
 * 寻找有向图中的最后一个冗余边
 * 并且该有向图中只有每个节点最多只有一个后继节点
 * 题目限定了一定有符合条件的情况
 * {graph},{union-find}
 */
public class _685Solution {

    int[] parent;

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        if (find(x) != find(y))
            parent[find(y)] = parent[x];
    }

    /**
     * 关键在于有两个限制条件，一是不能有环，二是不能有入度为2的情况
     * @param edges
     * @return
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        parent = new int[1001];
        int[] in = new int[1001];
        int[] res = {};
        // 先判断是否存在入度为 2 的顶点
        for (int[] e : edges) {
            // res保存的是入度为2的点对应的第二条边
            if (++in[e[1]] == 2) {
                res = e;
            }
        }
        // 如果存在入度为 2 的顶点
        // 尝试删除指向该顶点的某一条边，看剩下的点是否能够构成树
        // 如果可以构成树，直接返回该边，否则返回另一条边
        if (res.length != 0) {
            if (check(edges, res))
                return res;
            else {
                for (int[] e : edges)
                    // 另外一条边肯定出现在res之前
                    if (e[1] == res[1])
                        return e;
            }
        }
        // 不存在入度为2的情况，需要判断是否有环路
        // 重新初始化并查集
        for (int i = 0; i < 1001; i++) {
            parent[i] = i;
        }
        for (int[] e : edges) {
            // 删除加入形成环的边
            if (find(e[0]) == find(e[1]))
                return e;
            else
                union(e[0], e[1]);
        }
        return new int[0];
    }

    // 判断有向边构成的图形是否为树
    boolean check(int[][] edges, int[] remove) {
        // 初始化并查集
        for (int i = 0; i < 1001; i++) {
            parent[i] = i;
        }
        for (int[] e : edges) {
            // 跳过要删除的边
            if (Arrays.equals(e, remove))
                continue;
            // 删除之后构成的图案不为树
            if (find(e[0]) == find(e[1]))
                return false;
            else
                union(e[0], e[1]);
        }
        return true;
    }
}
