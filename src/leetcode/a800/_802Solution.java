package leetcode.a800;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 有向图中从一个节点出发能够最终到达的节点全都是终止节点，叫做安全节点
 * 返回有向图中的所有安全节点
 * {graph},{dfs}
 */
public class _802Solution {

    /**
     * 实际上如果路径上没有任何环路，那么总会在终止节点终止
     * dfs遍历三色法，未完全遍历完的节点置为灰色
     * 如果新遍历的节点为灰色，说明遇到了环
     * 
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (safe(graph, color, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean safe(int[][] graph, int[] color, int x) {
        if (color[x] > 0) {
            return color[x] == 2;
        }
        color[x] = 1;
        for (int y : graph[x]) {
            if (!safe(graph, color, y)) {
                // y所在的某一个路径上有环
                // 直接返回，递归栈里面所有变成灰色的节点都不处理
                // 因为这些节点都有路径通往一个环
                // 灰色的节点有可能是本次递归发现的，也有可能是之前发现的环上的
                return false;
            }
        }
        // 至此说明x不在环上
        color[x] = 2;
        return true;
    }

    int N = (int) 1e4 + 10, M = 4 * N;
    int idx;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int[] cnts = new int[N];

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    /**
     * 使用拓扑排序解决这个问题
     * {bfs},{topologic sorting},{reverse thinking}
     * @param g
     * @return
     */
    public List<Integer> eventualSafeNodes1(int[][] g) {
        int n = g.length;
        // 存反向图，并统计入度
        Arrays.fill(he, -1);
        for (int i = 0; i < n; i++) {
            for (int j : g[i]) {
                add(j, i);
                cnts[i]++;
            }
        }
        // BFS 求反向图拓扑排序
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cnts[i] == 0)
                d.addLast(i);
        }
        while (!d.isEmpty()) {
            int poll = d.pollFirst();
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--cnts[j] == 0)
                    d.addLast(j);
            }
        }
        // 遍历答案：如果某个节点出现在拓扑序列，说明其进入过队列，说明其入度为 0
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cnts[i] == 0)
                ans.add(i);
        }
        return ans;
    }
}
