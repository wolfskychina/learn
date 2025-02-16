package leetcode.a2000;

/**
 * 使得网格中的所有数相同的最小操作数
 * 每次可以将网格中的任意数 +- x
 * {greedy}
 */
public class _2033Solution {
  
    /**
     * 全都变成中位数需要的总操作数最小
     * @param grid
     * @param x
     * @return
     */
    public int minOperations(int[][] grid, int x) {
        
        int a[] = new int[grid.length*grid[0].length];
        int k=0;
        for(int i=0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                a[k++]   = grid[i][j];

            }
        }
        Arrays.sort(a);
        int res= 0;
        int mid = a[a.length/2];
        for(int i:a){
            if(Math.abs(mid-i)%x!=0)
                return -1;
            res+=Math.abs(mid-i)/x;
        }
        return res;
    }
}
