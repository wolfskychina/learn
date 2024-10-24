package leetcode.a2000;

import java.util.ArrayList;

/**
 * 二的幂数组中查询范围内的成绩
 * {bit manipulation},{prefix sum}
 */
public class _2438Solution {

    public static final int MOD = 1000000007;

    public int[] productQueries(int n, int[][] queries) {

        var s = new ArrayList<Integer>();
        s.add(0);
        while (n > 0) {
            s.add(s.get(s.size() - 1) + Integer.numberOfTrailingZeros(n));
            n &= (n - 1);
        }

        int[] ans = new int[queries.length];
        int mm = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            int p = s.get(r + 1) - s.get(l);
            ans[mm++] = fastpow(2, p);
        }

        return ans;

    }

    public int fastpow(int x, int p) {
        long mul = 1;
        while (p > 0) {
            if ((p & 1) > 0) {
                mul = mul * x % MOD;
            }
            p >>= 1;
            x = (int) (1l * x * x % MOD);
        }
        return (int) (mul);
    }
}
