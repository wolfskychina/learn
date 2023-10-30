package leetcode.a400;
/**
 * 矩阵按照对角线往返遍历
 */
public class _498Solution {

    /**
     * 关键1：总的遍历对角线的次数为m+n-1
     * 关键2: 每个对角线上的坐标的和是i，i是对角线的序号[0,m+n-2]
     * 关键3：m和n不相等，每个对角线遍历的起始点和m或者n的长度有关
     * @param mat
     * @return
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int pos = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 1) {
                // 向左下方遍历，开始的若干次遍历是从x=0开始
                // 当超过n的时候，y恒等于n-1
                // 再根据x+y=i的等式，计算出另外一个坐标
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    res[pos] = mat[x][y];
                    pos++;
                    x++;
                    y--;
                }
            } else {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    res[pos] = mat[x][y];
                    pos++;
                    x--;
                    y++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        _498Solution so = new _498Solution();
        // int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] matrix = { { 2 }, { 3 } };
        so.findDiagonalOrder(matrix);
    }
}
