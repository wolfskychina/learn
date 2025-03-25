package leetcode.a2000;

/**
 * 元素对角线两侧的不同数字数量的差值
 * {prefix sum},{bit manuplation}
 */
public class _2711Solution {

    /**
     * 元素取值范围在50以内，可以用64位的long类型表示
     * @param grid
     * @return
     */
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];

        for (int k = 1; k < m + n; k++) {
            int minJ = Math.max(n - k, 0);
            int maxJ = Math.min(m + n - 1 - k, n - 1);

            long set = 0;
            for (int j = minJ; j <= maxJ; j++) {
                int i = k + j - n;
                ans[i][j] = Long.bitCount(set); // 计算 set 中 1 的个数
                set |= 1L << grid[i][j]; // 把 grid[i][j] 加到 set 中
            }

            set = 0;
            for (int j = maxJ; j >= minJ; j--) {
                int i = k + j - n;
                ans[i][j] = Math.abs(ans[i][j] - Long.bitCount(set));
                set |= 1L << grid[i][j];
            }
        }
        return ans;
    }
}
