package leetcode.a1300;

import leetcode.util.graph.UnionFind;

/**
 * 在一组计算机中，已经有connections种连接方式
 * 问最少能重连多少根网线，使得所有计算机都在同一个网络中
 * 如果无法实现，返回-1
 */
public class _1319Solution {

    /**
     * {union find}
     * 
     * @param n
     * @param connections
     * @return
     */
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        UnionFind uf = new UnionFind(n);
        for (int[] conn : connections) {
            uf.unite(conn[0], conn[1]);
        }

        return uf.setCount - 1;
    }
}
