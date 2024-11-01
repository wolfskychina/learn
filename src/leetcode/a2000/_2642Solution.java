package leetcode.a2000;

import java.util.Arrays;

/**
 * 设计一个类，能够增加图的边和返回任意两条边的最短距离
 * {design},{graph},{floyd-warshall}
 */
public class _2642Solution {

    class Graph {
        private static final int INF = Integer.MAX_VALUE / 3; // 防止更新最短路时加法溢出

        private final int[][] f;

        public Graph(int n, int[][] edges) {
            f = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(f[i], INF);
                f[i][i] = 0;
            }
            for (int[] e : edges) {
                f[e[0]][e[1]] = e[2]; // 添加一条边（题目保证没有重边和自环）
            }
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    if (f[i][k] == INF) {
                        continue;
                    }
                    for (int j = 0; j < n; j++) {
                        f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j]);
                    }
                }
            }
        }

        public void addEdge(int[] e) {
            int x = e[0], y = e[1], w = e[2], n = f.length;
            if (w >= f[x][y]) { // 无需更新
                return;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    f[i][j] = Math.min(f[i][j], f[i][x] + w + f[y][j]);
                }
            }
        }

        public int shortestPath(int start, int end) {
            int ans = f[start][end];
            return ans < INF ? ans : -1;
        }
    }

}
