package leetcode.a2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有向无环图中每个节点的所有祖先列表
 */
public class _2192Solution {

    /**
     * {graph},{dfs}
     * 先考虑最简单的dfs能否解决问题,没有必要用拓扑排序
     * @param n
     * @param edges
     * @return
     */
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[1]].add(e[0]); // 反向建图
        }

        List<Integer>[] ans = new ArrayList[n];
        Arrays.setAll(ans, i -> new ArrayList<>());
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis, false);
            dfs(i, g, vis); // 从 i 开始 DFS
            vis[i] = false; // ans[i] 不含 i
            for (int j = 0; j < n; j++) {
                if (vis[j]) {
                    ans[i].add(j);
                }
            }
        }
        return Arrays.asList(ans);
    }

    private void dfs(int x, List<Integer>[] g, boolean[] vis) {
        vis[x] = true; // 避免重复访问
        for (int y : g[x]) {
            if (!vis[y]) {
                dfs(y, g, vis); // 只递归没有访问过的点
            }
        }
    }
}
