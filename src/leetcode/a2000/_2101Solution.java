package leetcode.a2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 不同炸弹的爆炸范围不一样，炸弹可以连环的引爆
 * 问一次最多能够引爆的炸弹的数量
 * 本质是有向图
 * {gragh},{dfs}
 */
public class _2101Solution {

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            long x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
            for (int j = 0; j < n; j++) {
                long dx = x - bombs[j][0];
                long dy = y - bombs[j][1];
                if (dx * dx + dy * dy <= r * r) {
                    g[i].add(j); // i 可以引爆 j
                    // 但是反过来，j不一定能引爆i
                    // 所以本质上是有向图
                }
            }
        }

        int ans = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(vis, false);
            ans = Math.max(ans, dfs(g, vis, i));
        }
        return ans;
    }

    private int dfs(List<Integer>[] g, boolean[] vis, int x) {
        vis[x] = true;
        int cnt = 1;
        for (int y : g[x]) {
            if (!vis[y]) {
                cnt += dfs(g, vis, y);
            }
        }
        return cnt;
    }
}
