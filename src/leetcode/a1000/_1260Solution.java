package leetcode.a1000;

import java.util.ArrayList;
import java.util.List;
/**
 * 二维网格偏移
 * {easy}
 */
public class _1260Solution {
   
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        k = k%(grid.length*grid[0].length);
        int[][] res = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                res[(i*grid[0].length+j+k)/grid[0].length%grid.length][(j+k%grid[0].length)%grid[0].length] = grid[i][j];
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<res.length;i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j=0;j<res[0].length;j++){

                tmp.add(res[i][j]);
            }
            list.add(tmp);
        }
        return list;
    }
}
