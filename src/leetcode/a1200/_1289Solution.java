package leetcode.a1200;

/**
 * 下降路径最小和，不能选上方的节点
 * {dp}
 */
public class _1289Solution {

    /**
     * on3的时间复杂度，比较慢
     * @param grid
     * @return
     */
    public int minFallingPathSum(int[][] grid) {
        if(grid.length==1) return grid[0][0];
        int[] res =new int[grid[0].length];
        for(int i=0;i<res.length;i++){
            res[i] = grid[0][i];
        }
        for(int i=1;i<grid.length;i++){

            int[] rr=new int[grid[0].length];
            
            for(int j=0;j<grid[0].length;j++){
                
                int min = Integer.MAX_VALUE;
                for(int k=0;k<grid[0].length;k++){
                    if(k==j) continue;
                    min = Math.min(min, res[k]);
                }
                rr[j] = min+grid[i][j];
            }
            res = rr;
        }
        int minval = Integer.MAX_VALUE;
        for(int i:res){
            minval = Math.min(minval, i);
        }
        return minval;

    }

    /**
     * 实际上每个节点能选择的路径，只和上一层最大值和次大值有关
     * 因为最大值和次大值对应的上层节点肯定不是一个
     * @param grid
     * @return
     */
    public int minFallingPathSum1(int[][] grid) {
        int n = grid.length;
        int first_min_sum = 0;
        int second_min_sum = 0;
        int first_min_index = -1;

        for (int i = 0; i < n; i++) {
            int cur_first_min_sum = Integer.MAX_VALUE;
            int cur_second_min_sum = Integer.MAX_VALUE;
            int cur_first_min_index = -1;

            for (int j = 0; j < n; j++) {
                int cur_sum = (j != first_min_index ? first_min_sum : second_min_sum) + grid[i][j];
                if (cur_sum < cur_first_min_sum) {
                    cur_second_min_sum = cur_first_min_sum;
                    cur_first_min_sum = cur_sum;
                    cur_first_min_index = j;
                } else if (cur_sum < cur_second_min_sum) {
                    cur_second_min_sum = cur_sum;
                }
            }
            first_min_sum = cur_first_min_sum;
            second_min_sum = cur_second_min_sum;
            first_min_index = cur_first_min_index;
        }
        return first_min_sum;
    }

}
