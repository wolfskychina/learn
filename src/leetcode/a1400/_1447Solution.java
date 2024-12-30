package leetcode.a1400;

import java.util.ArrayList;
import java.util.List;

/**
 * 分母未n或者更小的数能够组成的小于1的最简分数
 * {gcd},{math},{easy}
 * 
 */
public class _1447Solution {

    public List<String> simplifiedFractions(int n) {

        List<String> res = new ArrayList<>();

        for (int i = 1; i < n; i++) {

            for (int j = i + 1; j <= n; j++) {

                if (gcd(i, j) == 1) {
                    res.add("" + i + "/" + j);
                }
            }
        }
        return res;
    }

    private int gcd(int a, int b) {

        while (a % b != 0) {

            int tmp = a % b;
            a = b;
            b = tmp;
        }

        return b;
    }
}
