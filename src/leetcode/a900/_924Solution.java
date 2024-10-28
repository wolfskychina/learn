package leetcode.a900;

/**
 * 尽量减少恶意软件的转播
 * {graph},{dfs}
 */
public class _924Solution {

    private boolean[] visited; // 标记节点i是否访问过
    private int infects; // 一个连通块上初始感染节点数

    /**
     * 关键：同一连通块上如果有多个初始节点，那么仅消除一个节点
     * 无法使得最终被感染的数量变小
     * @param graph
     * @param initial
     * @return
     */
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        boolean[] initial_set = new boolean[n]; // 将列表转为集合，用于快速判断一个节点是否为初始感染节点
        int mn = initial[0]; // 初始感染节点的最小索引
        for (int init : initial) {
            initial_set[init] = true;
            mn = Math.min(mn, init);
        }
        visited = new boolean[n];

        int maxSize = 0; // 最大连通块尺寸
        int res = -1; // 结果

        for (int root : initial) {
            if (visited[root])
                continue; // 跳过已访问的节点，节点已访问说明其所在连通块已处理
            infects = 0; // 初始一个连通块的初始感染节点数为0
            int blockSize = dfs(root, n, graph, initial_set); // 以当前初始感染节点为起点开始搜索
            if (infects == 1 && (blockSize > maxSize || (blockSize == maxSize && root < res))) {
                // 如果连通块上只有一个感染节点，且这个感染节点所在连通块尺寸更大或者一样索引更小，更新
                maxSize = blockSize;
                res = root;
            }
        }
        if (res < 0) {
            // res未更新，说明不存在只有一个感染节点的连通块，因此去掉哪个感染节点效果都一样，取最小索引
            return mn;
        }
        return res;
    }

    /**
     * 深度优先搜索，访问一个连通块上的所有节点
     * 并统计连通块上初始感染节点数，返回连通块节点个数
     */
    private int dfs(int node, int n, int[][] graph, boolean[] initial_set) {
        int cnt = 1; // 统计连通块上节点个数，初始为1表示node本身
        visited[node] = true; // 标记node已访问
        if (initial_set[node]) {
            infects++; // 统计连通块初始感染节点数
        }
        for (int i = 0; i < n; i++) {
            if (i == node || graph[node][i] == 0)
                continue; // 跳过节点本身和不与节点相连的节点
            if (!visited[i])
                cnt += dfs(i, n, graph, initial_set); // 递归搜索未访问的邻节点，并累加访问的节点个数
        }
        return cnt; // 返回统计的节点数
    }

    public static void main(String[] args) {

        _924Solution so = new _924Solution();
        int[][] gragh = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        int[] initial = { 0, 2 };
        so.minMalwareSpread(gragh, initial);

    }
}
