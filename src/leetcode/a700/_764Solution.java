package leetcode.a700;

import java.util.Arrays;

/**
 * 矩阵中最长的连续1形成的十字型的大小
 */
public class _764Solution{


    /**
     * 想象有四个矩阵分别存储每个节点从四个方向的边到达该节点时连续的1的个数
     * 类似于四个方向的前缀和
     * 然后从每个节点出发的最长十字形状就是四个方向连续1的最小值
     * 所有节点的最小值中的最大值就是整个形状中最大的十字1
     * {dp},{prefix sum}
     * @param n
     * @param mines
     * @return
     */
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] g = new int[n + 10][n + 10];
        for (int i = 1; i <= n; i++) Arrays.fill(g[i], 1);
        for (int[] info : mines) g[info[0] + 1][info[1] + 1] = 0;
        int[][] a = new int[n + 10][n + 10], b = new int[n + 10][n + 10], c = new int[n + 10][n + 10], d = new int[n + 10][n + 10];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (g[i][j] == 1) {
                    a[i][j] = a[i - 1][j] + 1;
                    b[i][j] = b[i][j - 1] + 1;
                }
                if (g[n + 1 - i][n + 1 - j] == 1) {
                    c[n + 1 - i][n + 1 - j] = c[n + 2 - i][n + 1 - j] + 1;
                    d[n + 1 - i][n + 1 - j] = d[n + 1 - i][n + 2 - j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ans = Math.max(ans, Math.min(Math.min(a[i][j], b[i][j]), Math.min(c[i][j], d[i][j])));
            }
        }
        return ans;
    }
}