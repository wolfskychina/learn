package leetcode.a2000;

/**
 * 构造最长的新字符串
 * x个AA，y个BB，z个AB拼接字符串，要求不能有连续的AAA和BBB
 * 求最多能拼接多长的字符串
 * {dp}，{greedy}
 */
public class _2745Solution {

    /**
     * 满足递推关系可以使用dp，但是速度很慢
     * 
     * @param x
     * @param y
     * @param z
     * @return
     */
    public int longestString(int x, int y, int z) {
        int[][][][] dp = new int[x + 1][y + 1][z + 1][3];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                for (int k = 0; k <= z; k++) {
                    if (i > 0) {
                        dp[i][j][k][0] = Math.max(dp[i - 1][j][k][1], dp[i - 1][j][k][2]) + 2;
                    }
                    if (j > 0) {
                        dp[i][j][k][1] = dp[i][j - 1][k][0] + 2;
                    }
                    if (k > 0) {
                        dp[i][j][k][2] = Math.max(dp[i][j][k - 1][1], dp[i][j][k - 1][2]) + 2;
                    }
                }
            }
        }
        return Math.max(Math.max(dp[x][y][z][0], dp[x][y][z][1]), dp[x][y][z][2]);
    }

    /**
     * 符合贪心规则
     * 直接根据一种贪心规则构造
     * AA，BB交替出现，可以最多使用2*Math.min(x,y)个x和y
     * 然后如果x和y数量不相同，那么可以让多的在首尾，然后交替出现
     * AB不管有多少个都可以放在上面构成的交替出现的AABB的某一侧
     * 但是再剩下的AA或者BB，无论如何也没法加到序列中
     * @param x
     * @param y
     * @param z
     * @return
     */
    public int longestString1(int x, int y, int z) {
        return 2 * (2 * Math.min(x, y) + (x == y ? 0 : 1) + z);
    }
}
