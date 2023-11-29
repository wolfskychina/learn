package leetcode.a700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
/**
 * 从一个节点传递信息到达其他所有节点的最短时间，如果有的节点不可达，返回-1
 */
public class _743Solution {

    /**
     * {Dijkstra},{priority queue},{graph}
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        List<int[]>[] g = new List[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            g[i] = new ArrayList<int[]>();
        }
        for (int[] t : times) {
            int x = t[0], y = t[1];
            g[x].add(new int[] { y, t[2] });
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[0] = -1;
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        pq.offer(new int[] { 0, k });
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int time = p[0], x = p[1];
            if (dist[x] < time) {
                continue;
            }
            for (int[] e : g[x]) {
                int y = e[0], d = dist[x] + e[1];
                if (d < dist[y]) {
                    dist[y] = d;
                    pq.offer(new int[] { d, y });
                }
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }

}
