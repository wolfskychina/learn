package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;

/**
 * 网格中在价格范围内权重最高的k个物品
 * {matrix},{bfs}
 */
public class _2146Solution {

    static final int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    /**
     * 有价格的限制条件，权重存在不同维度的排序方案
     * 因为最大权重的排序规则是距离，所以可以使用bfs
     * @param grid
     * @param pricing
     * @param start
     * @param k
     * @return
     */
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        var ans = new ArrayList<List<Integer>>();
        int m = grid.length, n = grid[0].length;
        var vis = new boolean[m][n];
        vis[start[0]][start[1]] = true;
        var q = new ArrayList<int[]>();
        q.add(start);
        while (!q.isEmpty()) { // 分层 BFS
            // 此时 q 内所有元素到起点的距离均相同，因此按照题目中的第 2~4 关键字排序后，就可以将价格在 [low,high] 内的位置加入答案
            q.sort((a, b) -> {
                int pa = grid[a[0]][a[1]], pb = grid[b[0]][b[1]];
                return pa != pb ? pa - pb : a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
            });
            for (var p : q)
                if (pricing[0] <= grid[p[0]][p[1]] && grid[p[0]][p[1]] <= pricing[1]) {
                    // 直接使用List.of()返回一个新的只读list
                    ans.add(List.of(p[0], p[1]));
                    if (ans.size() == k)
                        return ans;
                }
            var tmp = q;
            q = new ArrayList<>();
            for (var p : tmp)
                for (var d : dirs) {
                    int x = p[0] + d[0], y = p[1] + d[1];
                    if (0 <= x && x < m && 0 <= y && y < n && !vis[x][y] && grid[x][y] > 0) {
                        vis[x][y] = true;
                        q.add(new int[] { x, y });
                    }
                }
        }
        return ans;
    }
}
