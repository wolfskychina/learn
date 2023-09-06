package leetcode.a300;

/**
 * 稀疏矩阵的乘法
 */
public class _311Solution {
    // 改进的写法
    // 利用稀疏矩阵中的大部分元素是0, 这些可以跳过计算加速
    public int[][] multiply(int[][] a, int[][] b) {
        int n = a.length;
        int m = b[0].length;
        // k: 每一项需要计算的元素个数
        int k = a[0].length; // a的列数同时也是b的行数
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) { // 行
            for (int c = 0; c < k; c++) { // 每一项需要累加的个数
                if (a[i][c] == 0) { // 即: 矩阵A中第C个0元素项目, 没有必要参与后面的累加了
                    continue; // c++, 跳到下一个不为零的 a[i][c]上
                }
                for (int j = 0; j < m; j++) {
                    // 依然累加了a中0的项目
                    ans[i][j] += a[i][c] * b[c][j];
                }
            }
        }
        return ans;
    }
}
