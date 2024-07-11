package leetcode.a700;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 向无环图中，从起点到终点的所有路径
 */
public class _797Solution {

    List<List<Integer>> res;

    /**
     * {dag},{dfs}
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i : graph[0]) {
            visited.add(i);
            list.add(i);
            dfs(i, graph, visited, list, graph.length - 1);
            list.remove(list.size() - 1);
            visited.remove(i);
        }

        return res;

    }

    private void dfs(int i, int[][] graph, Set<Integer> visited, List<Integer> list, int tar) {

        if (i == tar) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int next : graph[i]) {

            if (visited.contains(next))
                continue;
            visited.add(next);
            list.add(next);
            dfs(next, graph, visited, list, tar);
            visited.remove(next);
            list.remove(list.size() - 1);
        }
        return;

    }


    /**
     * 因为已经是有向无环图，实际上不需要set来限制回路
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {

        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i : graph[0]) {
            list.add(i);
            dfs1(i, graph, list, graph.length - 1);
            list.remove(list.size() - 1);
        }

        return res;

    }

    private void dfs1(int i, int[][] graph, List<Integer> list, int tar) {

        if (i == tar) {
            res.add(new ArrayList<>(list));

            return;
        }
        for (int next : graph[i]) {

            
            list.add(next);
            dfs1(next, graph, list, tar);
            list.remove(list.size() - 1);
        }
        return;

    }
}
