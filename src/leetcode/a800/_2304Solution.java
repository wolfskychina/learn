package leetcode.a800;
/**
 * 网格中的最小路径代价
 */
public class _2304Solution {

    /**
     * {dp}
     * @param grid
     * @param moveCost
     * @return
     */
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[] cost = new int[grid[0].length];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {

            int[] newcost = new int[grid[0].length];
            for (int j = 0; j < grid[0].length; j++) {
                newcost[j] = Integer.MAX_VALUE;
                for (int k = 0; k < grid[0].length; k++) {

                    newcost[j] = Math.min(newcost[j], cost[k] + moveCost[grid[i - 1][k]][j]);

                }
                newcost[j] += grid[i][j];
            }
            cost = newcost;
        }
        int min = Integer.MAX_VALUE;
        for(int i:cost){
            min = Math.min(min,i);
        }

        return min;


    }
}
