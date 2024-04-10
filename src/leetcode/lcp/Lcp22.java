package leetcode.lcp;
/**
 * 黑白方格画，可以选若干行列，将这些行列涂黑
 * 求有多少种不同的涂法，能够恰好将k个格子涂黑
 * {math}
 */
public class Lcp22 {

    public int paintingPlan(int n, int k) {
        int res = 0;
        // 边界问题
        if (k == 0)
            return 1;
        if (k == n * n)
            return 1;

        // 第一层循环表示涂 i 行 第二层循环表示涂 j 列
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++)
                // 当你涂了 i 行 j 列 则有 i * n + j * n个方格被涂过了
                // 去掉重复计入的 i*j个方格 是否等于结果k
                if ((i * n) + (j * n) - (i * j) == k) {
                    res += C(i, n) * C(j, n);
                }
        }
        return res;
    }

    // 数学里的排列组合 C(愚蠢式写法，勿计较)
    public int C(int x, int y) {
        if (x == 0)
            return 1;
        int n = 1;
        for (int i = 0; i < x; i++) {
            n *= (y - i);
        }
        for (int i = 1; i <= x; i++) {
            n /= i;
        }
        return n;
    }
}
