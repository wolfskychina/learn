package leetcode.a3000;

import java.util.ArrayList;
import java.util.List;

/**
 * 统计树中好节点的数量
 * 好节点是指所有其所有子树的节点数量一致
 * {tree},{dfs}
 */
public class _3249Solution {

    int goodnum = 0;

    public int countGoodNodes(int[][] edges) {

        int n = edges.length + 1;
        List<Integer>[] list = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }

        dfs(0, list, visited);

        return goodnum;

    }

    private int dfs(int cur, List<Integer>[] list, boolean[] visited) {

        visited[cur] = true;
        int sum = 0;
        int flag = -1;
        for (int i : list[cur]) {

            if (visited[i])
                continue;
            int tmp = dfs(i, list, visited);
            sum += tmp;
            if (flag == -1) {
                flag = tmp;
            } else if (flag != tmp) {
                flag = -2;
            }
        }
        if (flag != -2)
            goodnum++;
        return sum + 1;
    }
}
