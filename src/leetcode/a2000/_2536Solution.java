package leetcode.a2000;

/**
 * 给一些子矩阵，对子矩阵所有元素加1
 * 求最后的矩阵
 * {matrix},{2d prefix sum}
 */
public class _2536Solution {

    /**
     * 使用了多行的一维前缀和
     * 但是速度好像不是很快
     * @param n
     * @param queries
     * @return
     */
    public int[][] rangeAddQueries(int n, int[][] queries) {

        int[][] res = new int[n][n];
        for (int[] q : queries) {

            for (int i = q[0]; i <= q[2]; i++) {

                res[i][q[1]]++;
                if (q[3] + 1 < n)
                    res[i][q[3] + 1]--;
            }
        }

        for (int i = 0; i < res.length; i++) {

            for (int j = 1; j < res[0].length; j++) {
                res[i][j] += res[i][j - 1];
            }
        }

        return res;
    }
}
