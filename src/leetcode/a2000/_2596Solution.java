package leetcode.a2000;
/**
 * 国际象棋马的走位方案
 */
public class _2596Solution {
   
    private static int[][] step={{-2,-1},{-1,-2},{1,-2},{2,-1},{-2,1},{-1,2},{1,2},{2,1}};

    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0) return false;
        int i=1;
        int x = 0;
        int y = 0;
        while(i<=grid.length*grid.length-1){

            boolean flag = false;
            int xx =0;
            int yy =0;
            for(int j=0;j<step.length;j++){
                 xx = x+step[j][0];
                 yy = y+step[j][1];
                if(valid(grid,xx,yy,i))
                 {
                     flag=true;   break;
                 }
            }
            if(!flag) return false;
            x =xx;
            y =yy;
            i++;
        }
        return true;
    }

    private boolean valid(int[][] grid, int x, int y ,int tar){

        if(x>=0&&x<grid.length&&y>=0&&y<grid.length&&grid[x][y]==tar)
            return true;
        return false;
    }
}
