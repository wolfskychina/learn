package leetcode.a1500;
/**
 * 二进制矩阵中的特殊位置
 * {easy}
 */
public class _1582Solution {
   
    public int numSpecial(int[][] mat) {

        int countr[] = new int[mat.length];
        int countc[] = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    countr[i]++;
                    countc[j]++;
                }
            }
        }
        int count =0;
        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && countr[i]==1&&countc[j]==1) {
                   count++;
                }
            }
        }
        return count;

    }
}
