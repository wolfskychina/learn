package leetcode.a2000;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 无向树/图，部分节点无法访问情况下可到达节点的数目
 * {tree},{graph},{bfs}
 */
public class _2368Solution {

    /**
     * 使用无向图的广度优先遍历，速度比较慢
     * 
     * @param n
     * @param edges
     * @param restricted
     * @return
     */
    public int reachableNodes(int n, int[][] edges, int[] restricted) {

        Set<Integer> re = new HashSet<>();
        for (int i : restricted) {
            re.add(i);
        }
        Set<Integer> visited = new HashSet<>();
        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (!visited.contains(cur)) {

                visited.add(cur);
                for (int i : list[cur]) {
                    if (!visited.contains(i) && !re.contains(i)) {
                        q.offer(i);
                    }
                }
            }
        }

        return visited.size();

    }

    /**
     * 使用union-find算法要快很多
     * 高级union-find数据结构，需要记录每一簇的节点数
     * union的时候，两簇的节点数也要合并
     * {union-find}
     * @param n
     * @param edges
     * @param restricted
     * @return
     */
    public int reachableNodes1(int n, int[][] edges, int[] restricted) {
        UnionFind uf = new UnionFind(n);
        HashSet<Integer> unvis = new HashSet<>();
        for (int x : restricted) {
            unvis.add(x);
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (unvis.contains(x) || unvis.contains(y)) {
                continue;
            }

            uf.union(x, y);
        }

        int p = uf.find(0);
        return uf.getCount(p);
    }

    public class UnionFind {
        private int[] counts = null;
        private int[] parents = null;

        public UnionFind(int n) {
            counts = new int[n];
            Arrays.fill(counts, 1);
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public int find(int x) {
            if (x == parents[x]) {
                return x;
            }

            return parents[x] = find(parents[x]);
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return;
            }

            if (counts[px] < counts[py]) {
                parents[px] = py;
                counts[py] += counts[px];
                counts[px] = 0;
            } else {
                parents[py] = px;
                counts[px] += counts[py];
                counts[py] = 0;
            }
        }

        public int getCount(int x) {
            return counts[x];
        }

    }
}
