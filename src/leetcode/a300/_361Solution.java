package leetcode.a300;
/**
 * 361. Bomb Enemy
 * 一颗炸弹能够炸死同一排和同一列的敌人，除非有墙挡着
 * 炸弹人游戏
 * 问一颗炸弹在图中最多能炸死多少敌人
 */
public class _361Solution {

    /**
     * 每一行从左往右能够炸死的人数具有递推关系
     * 类似四个方向都是如此
     * @param grid
     * @return
     */
    public int maxKilledEnemies(char[][] grid) {

        // element maybe '0','W','E'
        int m = grid.length;
        int n = grid[0].length;

        int max[][] = new int[m][n];
        int p = 0;

        for (int i = 0; i < m; i++) {
            p = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'E') {
                    p++;
                } else if (grid[i][j] == 'W') {
                    p = 0;
                }
                max[i][j] += p;

            }
            p = 0;
            for (int j = n - 1; j >= 0; j++) {
                if (grid[i][j] == 'E') {
                    p++;
                } else if (grid[i][j] == 'W') {
                    p = 0;
                }
                max[i][j] += p;
            }
        }

        for(int j=0;j<n;j++){
            p=0;
            for(int i=0;i<m;i++){
                if(grid[i][j] == 'E'){
                    p++;
                }else if(grid[i][j] == 'W'){
                    p = 0;
                }
                max[i][j] +=p;

            }
            p=0;
            for(int i=m-1;i>=0;i--){
                if(grid[i][j] == 'E'){
                    p++;
                }else if(grid[i][j] == 'W'){
                    p = 0;
                }
                max[i][j] +=p; 
            }

        }

        int res =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n && grid[i][j] == '0';j++){
                res = Math.max(res, max[i][j]);
            }
        }

        return res;
    }
}
