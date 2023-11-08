package leetcode.a500;

/**
 * 矩阵中最长的连续1的线段长度
 * 横竖和对角线方向 
 */
public class _562Solution {

    /**
     * {matrix traverse}
     * 最多只遍历四个方向即可
     * @param mat
     * @return
     */
    public int longestLine(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0)
                    continue;

                // traverse the four directions
                int ir = i;
                int jr = j;
                if (jr == 0 || mat[ir][jr - 1] == 0) {
                    int count = 0;
                    while (jr < n && mat[ir][jr] == 1) {
                        count++;
                        jr++;
                    }
                    max = Math.max(max, count);
                }
                ir = i;
                jr = j;
                if (ir == 0 || jr == 0 || mat[ir - 1][jr - 1] == 0) {
                    int count = 0;
                    while (ir < m && jr < n && mat[ir][jr] == 1) {
                        count++;
                        ir++;
                        jr++;
                    }
                    max = Math.max(max, count);
                }
                ir = i;
                jr = j;
                if (ir == 0 || mat[ir - 1][jr] == 0) {
                    int count = 0;
                    while (ir < m && mat[ir][jr] == 1) {
                        count++;
                        ir++;
                    }
                    max = Math.max(max, count);
                }
                ir = i;
                jr = j;
                if (ir == 0 || jr == n - 1 || mat[ir - 1][jr + 1] == 0) {
                    int count = 0;
                    while (ir < m && jr >= 0 && mat[ir][jr] == 1) {
                        count++;
                        ir++;
                        jr--;
                    }
                    max = Math.max(max, count);
                }
            }
        }

        return max;
    }

    public static void main(String[] args){
        _562Solution so = new _562Solution();
        int[][] mat ={{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}};
        so.longestLine(mat);
    }

}
