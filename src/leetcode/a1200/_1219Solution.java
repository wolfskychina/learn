package leetcode.a1200;

import java.util.HashSet;
import java.util.Set;

/**
 * 黄金矿工
 * {backtrace},{dfs}
 */
public class _1219Solution {

    int max = 0;

    public int getMaximumGold(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                dfs(grid, i, j, 0, new HashSet<Integer>());
            }
        }

        return max;
    }

    int[][] step = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    private void dfs(int[][] grid, int i, int j, int curSum, Set<Integer> visited) {
        max = Math.max(max, curSum + grid[i][j]);
        visited.add(i * 1000 + j);
        for (int k = 0; k < 4; k++) {
            int ii = i + step[k][0];
            int jj = j + step[k][1];
            if (valid(ii, jj, grid, visited)) {
                dfs(grid, ii, jj, curSum + grid[i][j], visited);
            }
        }
        visited.remove(i * 1000 + j);

    }

    private boolean valid(int i, int j, int[][] grid, Set<Integer> visited) {
        return (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != 0
                && !visited.contains(i * 1000 + j));
    }

    private int res;
    private boolean [][] middleNode;

    /**
     * 判断是否为中间结点进行剪枝，速度快很多
     * @param grid
     * @return
     */
    public int getMaximumGold1(int[][] grid) {
        res = 0;
        middleNode = new boolean[grid.length][grid[0].length];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] > 0 && !middleNode[x][y]) {
                    dfs(grid, x, y, 0);
                }
            }
        }
        return res;
    }

    private boolean dfs(int[][] grid, int i, int j, int wealth) {
        // 表示当前试图延伸的方向是无效的
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0) {
            res = Math.max(res, wealth);
            return false;
        }

        int gold = grid[i][j];
        grid[i][j] = 0;
        boolean r = dfs(grid, i + 1, j, wealth + gold);
        boolean l = dfs(grid, i - 1, j, wealth + gold);
        boolean t = dfs(grid, i, j + 1, wealth + gold);
        boolean d = dfs(grid, i, j - 1, wealth + gold);
        grid[i][j] = gold;

        // 如果一个节点四个方向都无法成功延伸到下一节点，说明就是末端节点
        // 否则就是中间结点，该节点无需作为起点进行遍历
        middleNode[i][j] = r || l || t || d;
        

        return true;
    }
}
