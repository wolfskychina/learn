package leetcode.a2000;

import java.util.HashMap;
import java.util.Map;

/**
 * 将相同的长宽比归类
 * {gcd},{math}
 */
public class _2001Solution {

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long interchangeableRectangles(int[][] arr) {
        Map<Long, Long> map = new HashMap<>();
        final long BASE = (long) 1e8;

        for (var p : arr) {
            int a = p[0], b = p[1];
            int div = gcd(a, b);
            // String frac = (a / div) + "/" + (b / div);
            // 使用数字压缩 [x, y] 比较快
            long frac = (a / div) * BASE + (b / div);
            map.put(frac, map.getOrDefault(frac, 0L) + 1);
        }

        long sum = 0L;
        for (var x : map.values()) {
            sum += x * (x - 1) / 2;
        }

        return sum;
    }
}
