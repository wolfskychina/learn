package leetcode.a700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _787Solution {

    int min = Integer.MAX_VALUE;
    boolean found = false;

    /**
     * {dfs},{TLE}搜索，注意回路。结果超时
     * 
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<int[]> ne[] = new List[n];
        for (int i = 0; i < ne.length; i++) {
            ne[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {

            ne[flights[i][0]].add(flights[i]);
        }

        Set<Integer> set = new HashSet<>();
        set.add(src);
        dfs(ne, src, dst, 0, 0, k, set);

        return found ? min : -1;

    }

    private void dfs(List<int[]>[] ne, int src, int dst, int stops, int cost, int k, Set<Integer> set) {

        if (src == dst) {

            min = Math.min(min, cost);
            found = true;
            return;

        }
        if (stops == k + 1)
            return;
        if (ne[src] == null)
            return;

        for (int[] next : ne[src]) {
            int nextnode = next[1];
            int price = next[2];
            if (set.contains(nextnode)) {
                continue;
            }
            set.add(nextnode);
            dfs(ne, nextnode, dst, stops + 1, cost + price, k, set);
            set.remove(nextnode);
        }
        return;
    }

    /**
     * {dp} f[t][i] 表示通过恰好 t 次航班，从出发城市 src到达城市 i 需要的最小花费
     * f[t][i]= min {f[t−1][j]+cost(j,i)} , (j,i)∈flights
     * 
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[][] f = new int[k + 2][n];
        for (int i = 0; i < k + 2; ++i) {
            Arrays.fill(f[i], INF);
        }
        f[0][src] = 0;
        for (int t = 1; t <= k + 1; ++t) {
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
            }
        }
        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, f[t][dst]);
        }
        return ans == INF ? -1 : ans;
    }

    /**
     * {Bellman-ford} 迭代k+1次之后的最小值就是能够走到的最小值
     */
    int N = 110, INF = 0x3f3f3f3f;
    int[] dist = new int[N];
    public int findCheapestPrice3(int n, int[][] flights, int src, int dst, int k) {
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for (int limit = 0; limit < k + 1; limit++) {
            int[] clone = dist.clone();
            for (int[] f : flights) {
                int x = f[0], y = f[1], w = f[2];
                dist[y] = Math.min(dist[y], clone[x] + w);
            }
        }
        return dist[dst] > INF / 2 ? -1 : dist[dst];
    } 

    public static void main(String[] args) {

        _787Solution so = new _787Solution();
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        so.findCheapestPrice(4, flights, 0, 3, 1);
    }
}
