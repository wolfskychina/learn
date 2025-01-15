package leetcode.a2000;

import java.util.Arrays;

/**
 * 表示一个折线图的最少线段数
 * {Geometry},{math}
 */
public class _2280Solution {

    /**
     * 核心判断三点同线
     * @param stockPrices
     * @return
     */
    public int minimumLines(int[][] stockPrices) {

        if (stockPrices.length < 3)
            return stockPrices.length - 1;

        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);
        int res = 1;
        int ori[] = new int[2];
        ori = stockPrices[0];
        for (int i = 2; i < stockPrices.length; i++) {

            if (!threePoitsNotInALine(ori, stockPrices[i - 1], stockPrices[i])) {

                ori = stockPrices[i - 1];
                res++;
            }
        }
        return res;

    }

    /**
     * 注意精度溢出
     * @param a
     * @param b
     * @param c
     * @return
     */
    private boolean threePoitsNotInALine(int[] a, int[] b, int[] c) {
        return (long) (c[1] - a[1]) * (c[0] - b[0]) == (long) (c[1] - b[1]) * (c[0] - a[0]);
    }
}
