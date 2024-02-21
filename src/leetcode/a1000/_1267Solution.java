package leetcode.a1000;

import java.util.ArrayList;
import java.util.List;
/**
 * 能够通信的服务器的数量
 * 统计多少个某行和某列只有一个服务器
 */
public class _1267Solution {
   
    public int countServers(int[][] grid) {
        int sum =0;
        List<Integer> nullcol = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            int tmp =0;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                 {   sum++;
                        tmp++;
                 }
                
            }
            if(tmp==1){
                nullcol.add(i);
            }
        }
        List<Integer> nullrow = new ArrayList<>();

        for(int j=0;j<grid[0].length;j++){

            int tmp =0;
            for(int i=0;i<grid.length;i++){

                if(grid[i][j]==1)
                    tmp++;
            }
            if(tmp==1)
                nullrow.add(j);
        }

        for(int i:nullcol){
            for(int j:nullrow){

                if(grid[i][j]==1){
                    sum--;
                }
            }
        }

        return sum;
    }
}
