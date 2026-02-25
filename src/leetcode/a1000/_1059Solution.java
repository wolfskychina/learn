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

    /**
     * 深度优先搜索判断从当前节点出发的所有路径是否都能到达目标节点
     * @param adj 邻接表表示的图
     * @param v 当前访问的节点
     * @param d 目标节点
     * @param visited 记录已访问过的节点，防止重复访问
     * @param onPath 记录当前DFS路径上的节点，用于检测环
     * @return 如果从当前节点v出发的所有路径都能到达目标节点则返回true，否则返回false
     */
    public boolean dfs(List<Integer>[] adj, int v, int d, boolean[] visited, boolean[] onPath) {
        // 如果当前节点没有出边，则只有当该节点就是目标节点时才满足条件
        if (adj[v].size() == 0)
            return v == d;
        
        // 标记当前节点为已访问和在当前路径上
        visited[v] = true;
        onPath[v] = true;
        
        // 遍历当前节点的所有邻接节点
        for (int next : adj[v])
            // 如果下一个节点已经在当前路径上，说明存在环，返回false
            // 或者如果下一个节点未被访问且其后续路径不能到达目标节点，也返回false
            if (onPath[next] || (!visited[next] && !dfs(adj, next, d, visited, onPath)))
                return false;
        
        // 回溯：将当前节点从路径中标记移除
        onPath[v] = false;
        return true;
    }
}
