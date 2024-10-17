package leetcode.a600;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 高尔夫球场砍树问题
 * 要求只能按照高度顺序由低向高砍
 */
public class _675Solution {

    int N = 50;
    int[][] g = new int[N][N];
    int n, m;

    /**
     * 因为树的高低顺序是固定的，因此只有一条可能路径
     * 对高度相邻节点bfs求最短路径即可
     * {matrix},{bfs}
     * @param forest
     * @return
     */
    public int cutOffTree(List<List<Integer>> forest) {
        n = forest.size();
        m = forest.get(0).size();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = forest.get(i).get(j);
                if (g[i][j] > 1)
                    list.add(new int[] { g[i][j], i, j });
            }
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        int x = 0, y = 0, ans = 0;
        for (int[] ne : list) {
            int nx = ne[1], ny = ne[2];
            int d = bfs(x, y, nx, ny);
            if (d == -1)
                return -1;
            ans += d;
            x = nx;
            y = ny;
        }
        return ans;
    }

    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    int bfs(int X, int Y, int P, int Q) {
        if (X == P && Y == Q)
            return 0;
        boolean[][] vis = new boolean[n][m];
        Deque<int[]> d = new ArrayDeque<>();
        d.addLast(new int[] { X, Y });
        vis[X][Y] = true;
        int ans = 0;
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                int[] info = d.pollFirst();
                int x = info[0], y = info[1];
                for (int[] di : dirs) {
                    int nx = x + di[0], ny = y + di[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                        continue;
                    if (g[nx][ny] == 0 || vis[nx][ny])
                        continue;
                    if (nx == P && ny == Q)
                        return ans + 1;
                    d.addLast(new int[] { nx, ny });
                    vis[nx][ny] = true;
                }
            }
            ans++;
        }
        return -1;
    }
}
