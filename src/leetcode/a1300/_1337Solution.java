package leetcode.a1300;

import java.util.Arrays;
/**
 * 矩阵中战斗力最弱的前N行
 */
public class _1337Solution {
   
    /**
     * {index sorting}
     * @param mat
     * @param k
     * @return
     */
    public int[] kWeakestRows(int[][] mat, int k) {

        int [] stren = new int[mat.length];
        for(int i=0;i<stren.length;i++){
            int count=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1)
                    count++;
                else    
                    break;
            }
            stren[i] =count;
        }
        Integer [] idx = new Integer[stren.length];
        for(int i=0;i<idx.length;i++){
            idx[i]=i;
        }
        Arrays.sort(idx,(o1,o2)->stren[o1]-stren[o2]);

        int res[] = new int[k];
        for(int i=0;i<k;i++){
            res[i] = idx[i];
        }
        return res;
    }
}
