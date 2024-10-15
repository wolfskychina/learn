package leetcode.a1000;

/**
 * 二维网格图中探测是否有环
 * {matrix},{dfs}
 */
public class _1559Solution {

    boolean[][] visited;
    char[][] grid;
    int m, n;
    boolean hasRing;

    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, grid[i][j], 'L');
                    if (hasRing)
                        return true;
                }
            }
        }
        return false;
    }

    private void dfs(int i, int j, char ch, char from) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != ch) {
            return;
        }
        if (visited[i][j]) {
            hasRing = true;
            return;
        }
        visited[i][j] = true;
        if (from != 'L')
            dfs(i, j - 1, ch, 'R');
        if (from != 'R')
            dfs(i, j + 1, ch, 'L');
        if (from != 'U')
            dfs(i - 1, j, ch, 'D');
        if (from != 'D')
            dfs(i + 1, j, ch, 'U');
    }
}
