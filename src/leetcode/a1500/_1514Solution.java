package leetcode.a1500;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 从起点到终点路径概率乘积最大的概率
 * {graph},{dijkstra}
 */
public class _1514Solution {

    private class Pair {
        int v;
        double value;

        public Pair(int v, double value) {
            this.v = v;
            this.value = value;
        }
    }

    /**
     * 需要注意初始化的值以及及时返回避免超时
     * @param n
     * @param edges
     * @param succProb
     * @param start_node
     * @param end_node
     * @return
     */
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        List<Pair>[] nei = new ArrayList[n];
        for (int i = 0; i < nei.length; i++) {
            nei[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {

            nei[edges[i][0]].add(new Pair(edges[i][1], succProb[i]));
            nei[edges[i][1]].add(new Pair(edges[i][0], succProb[i]));
        }
        double[] dist = new double[n];
        // Arrays.fill(dist, 0.0);
        dist[start_node] = 1.0;
        Queue<Pair> q = new PriorityQueue<>((a, b) -> Double.compare(b.value, a.value));
        q.offer(new Pair(start_node, 1.0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (dist[p.v] > p.value) {
                continue;
            }
            // TODO 可以提前终止，避免超时
            if (p.v == end_node)
                return p.value;
            for (Pair next : nei[p.v]) {

                int x = next.v;
                double d = dist[p.v] * next.value;
                if (d > dist[x]) {
                    dist[x] = d;
                    q.offer(new Pair(x, d));
                }

            }
        }

        if (dist[end_node] == Double.MIN_VALUE)
            return 0;
        else
            return dist[end_node];

    }
}
