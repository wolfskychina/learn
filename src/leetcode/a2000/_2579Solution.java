package leetcode.a2000;

/**
 * 统计染色格子数
 * 每次向相邻边染色，n轮过后一共有多少个被染色的格子
 * {math}
 */
public class _2579Solution {

    public long coloredCells(int n) {

        long res = 1;
        for (int i = 2, k = 1; i <= n; i++) {

            res += (long) 2 * k + 2;
            k += 2;
        }
        return res;
        // return 1 + 2 * n * (n - 1)
    }
}
