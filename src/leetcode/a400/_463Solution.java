package leetcode.a400;
/**
 * 值为1的空格组成的岛屿的周长
 * 只有一个岛屿，1的空格全部相连，岛屿中间没有水域的格子
 */
public class _463Solution {

    /**
     * 单个格子增加4的周长，如果有相邻的格子加入需要减去对应的数量，以2为单位
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    res += 4;

                    // 相邻的方块的总边数应该-2而不是-1
                    if (j != 0 && grid[i][j - 1] == 1) {
                        res -= 2;
                    }
                    if (i != 0 && grid[i - 1][j] == 1) {
                        res -= 2;
                    }

                }

            }
        }

        return res;
    }
}
