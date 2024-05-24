package leetcode.a300;
/**
 * 猜数字大小，如果猜错就付出猜测值的代价
 * 问最少准备多少代价值，能够保证猜中结果
 * {dp}
 */
public class _375Solution {
 
     /**
      * 往最大值方向进行二分不能保证是最小代价
      比如 1.2.3.4.5 如果是二分得出的最小代价是3+4
      实际上可以通过2+4的顺序保证猜测出来
      所以使用dp，令f[i][j]为[i,j]区间内猜测的最小代价
      TODO
      * @param n
      * @return
      */
     public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                // j=n的时候特殊处理，只有一个子区间
                f[i][j] = j + f[i][j - 1];
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }

 
}
