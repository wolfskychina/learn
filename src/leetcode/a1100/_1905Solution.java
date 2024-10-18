package leetcode.a1100;

/**
 * 判断一幅图中有多少岛屿是另外一幅图的子岛屿
 * 子岛屿必须是主岛屿的子集，不能有超出的部分
 * {matrix},{bfs}
 */
public class _1905Solution {

    public int countSubIslands(int[][] grid1, int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (dfs(grid1, grid, i, j)) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    public boolean dfs(int[][] grid1, int[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m) {
            return true;
        }
        if (grid[i][j] == 0) {
            return true;
        }

        grid[i][j] = 0;
        boolean flag = true;
        if (grid1[i][j] == 0) {
            // ⭐这里不能直接返回false，否则后面的dfs递归代码就不再执行了
            // 只是判断了不是子岛屿，但是不能立即返回
            // 保证所有相关节点都被置为0，需要继续遍历
            flag = false;
        }

        // ⭐必须要这样每一个都记录，来保证每一个dfs递归都执行
        // 不能直接reutrn dfs() && dfs() && dfs() && dfs()
        // 否则遇到第一个false，后面的就不再执行了
        boolean flag1 = dfs(grid1, grid, i - 1, j);
        boolean flag2 = dfs(grid1, grid, i + 1, j);
        boolean flag3 = dfs(grid1, grid, i, j - 1);
        boolean flag4 = dfs(grid1, grid, i, j + 1);

        return flag && flag1 && flag2 && flag3 && flag4;
    }
}
