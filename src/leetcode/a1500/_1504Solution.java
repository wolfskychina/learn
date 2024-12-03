package leetcode.a1500;

/**
 * 统计全由1组成的子矩形的数量
 * {prefix sum},{2d prefix}
 */
public class _1504Solution {

    /**
     * 统计右下角为1的子矩形的数量
     * 从下往上遍历
     */
    public int numSubmat(int[][] mat) {
        // 时间复杂度为O(m*n*n)
        int m = mat.length;
        int n = mat[0].length;

        // 先计算固定mat[i][j]为右下角，计算高度为1的行子矩阵个数。
        // 直接在原址上保存前缀和
        for (int i = 0; i < m; i++) {

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    count = 0;
                }
                mat[i][j] = count;
            }
        }

        int ans = 0;
        // 计算固定mat[i][j]为右下角，计算高度为i+1的子矩阵个数。
        // 从上往下计算
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                // 从下往上，取左边长度最小的才能组成多行的矩阵。
                // 长度为0的直接不用继续往上遍历。组成不了矩阵了。
                for (int k = i; k >= 0; k--) {
                    min = Math.min(min, mat[k][j]);
                    if (min == 0) {
                        break;
                    }
                    ans += min;
                }
            }
        }

        return ans;
    }
}
