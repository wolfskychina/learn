package leetcode.a1100;

/**
 * 网格中有六种形状的路线方块，问是否有一条可能的路线
 * 从起点到达终点？
 * {bfs},{matrix}
 */
public class _1391Solution {

    boolean ans = false;

    /**
     * 比较笨的方法，提前打表一种格子能通过每个方向走到哪几类格子
     * 
     * @param grid
     * @return
     */
    public boolean hasValidPath(int[][] grid) {
        // 0上1下2左3右
        boolean[][][] bp = new boolean[7][4][7];
        bp[1][2][1] = true;
        bp[1][3][1] = true;
        bp[1][3][3] = true;
        bp[1][3][5] = true;
        bp[1][2][4] = true;
        bp[1][2][6] = true;
        bp[2][0][2] = true;
        bp[2][0][3] = true;
        bp[2][0][4] = true;
        bp[2][1][2] = true;
        bp[2][1][5] = true;
        bp[2][1][6] = true;
        bp[3][2][1] = true;
        bp[3][2][4] = true;
        bp[3][2][6] = true;
        bp[3][1][2] = true;
        bp[3][1][5] = true;
        bp[3][1][6] = true;
        bp[4][1][2] = true;
        bp[4][1][5] = true;
        bp[4][1][6] = true;
        bp[4][3][1] = true;
        bp[4][3][3] = true;
        bp[4][3][5] = true;
        bp[5][0][2] = true;
        bp[5][0][3] = true;
        bp[5][0][4] = true;
        bp[5][2][1] = true;
        bp[5][2][4] = true;
        bp[5][2][6] = true;
        bp[6][0][2] = true;
        bp[6][0][3] = true;
        bp[6][0][4] = true;
        bp[6][3][1] = true;
        bp[6][3][3] = true;
        bp[6][3][5] = true;
        boolean[][] used = new boolean[grid.length][grid[0].length];
        dfs(grid, 0, 0, bp, used);
        return ans;
    }

    private void dfs(int[][] grid, int x, int y, boolean[][][] bp, boolean[][] used) {
        if (used[x][y])
            return;
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            ans = true;
            return;
        }
        used[x][y] = true;
        if (x > 0 && bp[grid[x][y]][0][grid[x - 1][y]])
            dfs(grid, x - 1, y, bp, used);
        if (x < grid.length - 1 && bp[grid[x][y]][1][grid[x + 1][y]])
            dfs(grid, x + 1, y, bp, used);
        if (y > 0 && bp[grid[x][y]][2][grid[x][y - 1]])
            dfs(grid, x, y - 1, bp, used);
        if (y < grid[0].length - 1 && bp[grid[x][y]][3][grid[x][y + 1]])
            dfs(grid, x, y + 1, bp, used);
        used[x][y] = false;
    }

    // 0 向上，1 向下，2 向左，3 向右，4 无法走
    private int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    // move[i][j] = k 是指 i 号街道可以由向 j 的方向进入，并能向 k 方向移动
    // 也是一种打表的方式
    private int[][] move = { {}, { 4, 4, 2, 3 }, { 0, 1, 4, 4 }, { 2, 4, 4, 1 }, { 3, 4, 1, 4 }, { 4, 2, 4, 0 },
            { 4, 3, 0, 4 } };
    private int n, m;
    private boolean[][] vis;

    public boolean hasValidPath1(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];
        int start = grid[0][0];
        for (int i = 0; i < 4; i++) {
            if (move[start][i] != 4) {
                // System.out.println(move[start][i]);
                if (dfs(grid, 0, 0, move[start][i]))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int[][] grid, int i, int j, int dir) {
        vis[i][j] = true;
        if (i == n - 1 && j == m - 1)
            return true;
        int ni = i + d[dir][0];
        int nj = j + d[dir][1];
        if (ni < 0 || ni >= n || nj < 0 || nj >= m)
            return false;
        int id = grid[ni][nj];
        if (move[id][dir] != 4 && !vis[ni][nj]) {
            // System.out.println("move: " + ni + " " + nj + " " + id + " " + dir + " " +
            // move[id][dir]);
            return dfs(grid, ni, nj, move[id][dir]);
        }
        return false;
    }
}
