package leetcode.a1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 有向图是否从起点出发的所有路径都能通向终点
 * {graph},{dfs} 
 */
public class _1059Solution {

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            adj[i] = new ArrayList<>();
        for (int[] edge : edges)
            adj[edge[0]].add(edge[1]);
        return dfs(adj, source, destination, new boolean[n], new boolean[n]);
    }

    public boolean dfs(List<Integer>[] adj, int v, int d, boolean[] visited, boolean[] onPath) {
        if (adj[v].size() == 0)
            return v == d;
        visited[v] = true;
        onPath[v] = true;
        for (int next : adj[v])
            // 第一个条件不需要判断visited，因为只要遇到在路径上是true的必定是有环，直接返回false
            // 后续只要有false都只会直接返回
            if (onPath[next] || (!visited[next] && !dfs(adj, next, d, visited, onPath)))
                return false;
        onPath[v] = false;
        return true;
    }
}
