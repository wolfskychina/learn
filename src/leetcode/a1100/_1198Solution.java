package leetcode.a1100;

/**
 * 找出矩阵所有行中的最小公共元素
 * 每行数据内部都是非重复的
 * {counting}
 */
public class _1198Solution {
   
    public int smallestCommonElement(int[][] mat) {

        int[] count = new int[10001];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){

                count[mat[i][j]]++;
            }
        }
        for(int i=0;i<count.length;i++){
            if(count[i]==mat.length)
            return i;
        }
        return -1;
    }
}
