package leetcode.a2000;

import java.util.HashSet;

/**
 * 数组乘积中的不同质因数的数量
 * {Math},{prime number}
 */
public class _2521Solution {

    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            for (int i = 2; i * i <= x; i++)
                if (x % i == 0) {
                    set.add(i);
                    // 消除已发现的因子i
                    // 保证每一轮满足if条件的数一定是素数
                    while (x % i == 0)
                        x /= i;
                }
            if (x > 1)
                set.add(x);
        }
        return set.size();
    }
}
