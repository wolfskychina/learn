package leetcode.a1000;

/**
 * 笨阶乘
 * 模拟
 */
public class _1006Solution {

    public int clumsy(int n) {

        int res = 1;
        res = 1 * n;
        if (--n == 0)
            return res;
        res *= n;
        if (--n == 0)
            return res;
        res /= n;
        if (--n == 0)
            return res;

        while (true) {

            res += n;
            if (--n == 0)
                return res;
            int tmp = 1;
            tmp *= n;
            if (--n == 0)
                return res - tmp;
            tmp *= n;
            if (--n == 0)
                return res - tmp;
            tmp /= n;
            if (--n == 0)
                return res - tmp;
            res -= tmp;
        }

    }
}
