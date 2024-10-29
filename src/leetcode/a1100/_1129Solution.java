package leetcode.a1100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * 交替颜色边进行遍历，从0到1,2,。。。n-1节点的最短路径长度
 * {graph},{bfs}
 */
public class _1129Solution {

    /**
     * 将节点抽象成两种颜色，从而将两种颜色路径的可能放到一起进行bfs
     * 自己的解法过于复杂
     * @param n
     * @param redEdges
     * @param blueEdges
     * @return
     */
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // 标明颜色。
        final int RED = 0;
        final int BLUE = 1;

        // 构建双层邻接表
        List<Integer>[][] adj = new ArrayList[2][n];
        for (int i = 0; i < n; i++) {
            adj[RED][i] = new ArrayList<>();
            adj[BLUE][i] = new ArrayList<>();
        }
        for (int[] edge : redEdges) {
            adj[RED][edge[0]].add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            adj[BLUE][edge[0]].add(edge[1]);
        }

        // 初始队列中同时含有蓝色源点和红色源点，并且我们也将相应颜色存入队列。
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {RED, 0});
        q.offer(new int[] {BLUE, 0});

        // 双层数组存储距离。
        int[][] dists = new int[2][n];
        Arrays.fill(dists[RED], Integer.MAX_VALUE);
        Arrays.fill(dists[BLUE], Integer.MAX_VALUE);
        dists[RED][0] = 0;
        dists[BLUE][0] = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int uColor = current[0], u = current[1];
            int vColor = uColor ^ 1; // 异或切换 1 和 0，等同于 1 - uColor，得到下条边的颜色

            for (int v : adj[vColor][u]) {
                if (dists[vColor][v] != Integer.MAX_VALUE) continue;
                dists[vColor][v] = dists[uColor][u] + 1;
                q.offer(new int[] {vColor, v});
            }
        }

        // 将双层数组中的距离合并取小，无穷大改成 -1。
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Math.min(dists[RED][i], dists[BLUE][i]);
            if (result[i] == Integer.MAX_VALUE) result[i] = -1;
        }
        return result;
    }

    public static void main(String[] args){
        _1129Solution so = new _1129Solution();

        int[][] red = {{0,1},{1,2},{2,3},{3,4}};
        int[][] blue = {{1,2},{2,3},{3,1}};
        so.shortestAlternatingPaths(5,red,blue);
    }
}
