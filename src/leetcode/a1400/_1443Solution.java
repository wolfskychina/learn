package leetcode.a1400;

import java.util.ArrayList;
import java.util.List;

/**
 * 收集树上所有苹果的最少时间
 * 无向图，不知道是否有回路
 * 已知每个点上是否有苹果
 * {tree},{undirected graph},{dfs}
 */
public class _1443Solution {

    int time = 0;

    /**
     * dfs使用visited避免重复访问，如果某个节点有苹果，那么返回路径上的所有节点都贡献
     * 一来一回两次的时间
     * 递归返回时需要动态修改hasApple来记录必须经过的节点
     * @param n
     * @param edges
     * @param hasApple
     * @return
     */
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        // visited保存访问过的节点
        boolean[] visited = new boolean[n];
        List<Integer> nei[] = new ArrayList[n];

        for (int i = 0; i < nei.length; i++) {
            nei[i] = new ArrayList<>();
        }
        for (int[] e : edges) {

            nei[e[0]].add(e[1]);
            nei[e[1]].add(e[0]);
        }

        dfs(0, visited, nei, hasApple);

        return time;
    }

    private boolean dfs(int cur, boolean[] visited, List<Integer>[] nei, List<Boolean> hasApple) {

        visited[cur] = true;
        boolean canChangeToApple = false;
        for (int i : nei[cur]) {
            if (!visited[i]) {
                canChangeToApple |= dfs(i, visited, nei, hasApple);
            }
        }

        hasApple.set(cur, hasApple.get(cur) || canChangeToApple);
        // 不能统计根节点
        if (hasApple.get(cur) && cur != 0) {
            // 必经节点贡献2
            time += 2;
        }
        return hasApple.get(cur);

    }
}
