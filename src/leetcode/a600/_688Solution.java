package leetcode.a600;
/**
 * 象棋棋盘中马从一个位置移动k次之后，仍然在棋盘内的概率
 */
public class _688Solution {

    double res = 0.0;
    int[][] step = { { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 } };

    /**
     * 递归累计统计所有的在键盘内的概率
     * 超时
     * @param n
     * @param k
     * @param row
     * @param column
     * @return
     */
    public double knightProbability(int n, int k, int row, int column) {

        if (row < 0 || column < 0 || row > n - 1 || column > n - 1)
            return 0.0;
        
        if(k==0) return  row >= 0 && row <= n - 1 && column >= 0 && column <= n - 1?1.0:0.0;

        // 递归调用，每一层的概率是一样的，每进一层，到达的概率是原来的八分之一
        for (int i = 0; i < 8; i++) {
            int xx = row + step[i][0];
            int yy = column + step[i][1];
            if (!valid(xx, yy, n))
                continue;
            if (k == 1)
                res += 1d / 8;
            else
                visit(1d / 8, xx, yy, k - 1, n);
        }

        return res;

    }

    private void visit(double p, int row, int column, int k, int n) {
        double newP = p / 8;
        for (int i = 0; i < 8; i++) {
            int xx = row + step[i][0];
            int yy = column + step[i][1];
            if (!valid(xx, yy, n))
                continue;
            if (k == 1)
                res += newP;
            else
                visit(newP, xx, yy, k - 1, n);
        }

    }

    private boolean valid(int xx, int yy, int n) {

        return xx >= 0 && xx <= n - 1 && yy >= 0 && yy <= n - 1;
    }

    private static final int[][] DIRS = {{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {1, -2}, {-2, 1}, {-1, -2}, {-2, -1}};

    /**
     * {dp} 倒过来思考，从x,y节点k步走到棋盘内的概率相当于，从棋盘内任意节点k步走到x,y节点的概率
     * @param n
     * @param k
     * @param row
     * @param column
     * @return
     */
    public double knightProbability1(int n, int k, int row, int column) {
        // 动态规划
        double[][][] dp = new double[n][n][k + 1];
        // k 从 0 开始变大
        for (int kk = 0; kk <= k; kk++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 走 0 步就到 [i, j] 的概率为1
                    if (kk == 0) {
                        dp[i][j][kk] = 1;
                    } else {
                        // 八个方向
                        for (int[] dir : DIRS) {
                            // 上一个坐标，这里用 减号 也是可以的
                            int ni = i + dir[0];
                            int nj = j + dir[1];
                            if (ni >= 0 && nj >= 0 && ni < n && nj < n) {
                                dp[i][j][kk] += dp[ni][nj][kk - 1] / 8.0;
                            }
                        }
                    }
                }
            }
        }
        // 返回走 k 步到 [row, column] 坐标的概率
        return dp[row][column][k];
    }


    public static void main(String[] args){
        _688Solution so = new _688Solution();
        so.knightProbability(3, 2, 0, 0);
    }
}
