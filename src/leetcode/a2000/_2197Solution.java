package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;

/**
 * 用两个数的最小公倍数不断替换数组中所有相邻的非互质数
 * {stack},{math}
 */
public class _2197Solution {

    /**
     * 用栈保存替换之后的数字，因为后续可能被继续替换
     * @param nums
     * @return
     */
    public List<Integer> replaceNonCoprimes(int[] nums) {
        var s = new ArrayList<Integer>();
        for (var num : nums) {
            s.add(num);
            while (s.size() > 1) {
                var x = s.get(s.size() - 1);
                var y = s.get(s.size() - 2);
                var g = gcd(x, y);
                if (g == 1)
                    break;
                s.remove(s.size() - 1);
                s.set(s.size() - 1, x / g * y);
            }
        }
        return s;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
