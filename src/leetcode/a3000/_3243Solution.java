package leetcode.a3000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 新增道路查询后的最短距离
 * 0-n-1的节点，初始的时候有0-1，1-2...n-2-n-1的有向边
 * 然后依次往图中插入queries的边
 * 求插入一条边后，从0到n-1的最短路径长度
 */
public class _3243Solution {

    /**
     * 邻接表，每次插入边后运行bfs
     * {graph},{bfs}
     * @param n
     * @param queries
     * @return
     */
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] g = new ArrayList[n - 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            g[i].add(i + 1);
        }

        int[] ans = new int[queries.length];
        int[] vis = new int[n - 1];
        for (int i = 0; i < queries.length; i++) {
            g[queries[i][0]].add(queries[i][1]);
            ans[i] = bfs(i + 1, g, vis, n);
        }
        return ans;
    }

    private int bfs(int i, List<Integer>[] g, int[] vis, int n) {
        List<Integer> q = new ArrayList<>();
        q.add(0);
        for (int step = 1;; step++) {
            List<Integer> tmp = q;
            q = new ArrayList<>();
            for (int x : tmp) {
                for (int y : g[x]) {
                    if (y == n - 1) {
                        return step;
                    }
                    // 巧妙的在每一轮复用visit数组而不用重新初始化
                    if (vis[y] != i) {
                        vis[y] = i;
                        q.add(y);
                    }
                }
            }
        }
    }
}
