package leetcode.a700;

import java.util.Arrays;
/**
 * 判断一个无向图是否是一个二分图
 * 二分图是指，图中的定点分为两个集合，所有的边的两个端点都分别在两个集合中
 */
public class _785Solution {
   
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;

    /**
     * 模拟染色过程，如果出现冲突则无法二分
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        valid = true;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n && valid; ++i) {
            if (color[i] == UNCOLORED) {
                dfs(i, RED, graph);
            }
        }
        return valid;
    }

    public void dfs(int node, int c, int[][] graph) {
        color[node] = c;
        int cNei = c == RED ? GREEN : RED;
        for (int neighbor : graph[node]) {
            if (color[neighbor] == UNCOLORED) {
                dfs(neighbor, cNei, graph);
                if (!valid) {
                    return;
                }
            } else if (color[neighbor] != cNei) {
                valid = false;
                return;
            }
        }
    }
}
