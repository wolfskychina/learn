package leetcode.a1000;
/**
 * 矩形对角线元素的和
 * {easy}
 */
public class _1572Solution {
   
    public int diagonalSum(int[][] mat) {

        int sum=0;
        for(int i=0;i<mat.length;i++){
            sum+=mat[i][i];
            sum+=mat[i][mat.length-1-i];
        }

        return mat.length%2==0?sum:sum-mat[mat.length/2][mat.length/2];
    }
}
