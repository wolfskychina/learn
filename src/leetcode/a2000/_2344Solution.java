package leetcode.a2000;

/**
 * 使数组可以被整除的最少删除次数
 * {math},{gcd}
 */
public class _2344Solution {

    public int minOperations(int[] nums, int[] numsDivide) {
        var g = 0;
        for (var x : numsDivide)
            g = gcd(g, x);
        var min = Integer.MAX_VALUE;
        for (var num : nums)
            if (g % num == 0)
                min = Math.min(min, num);
        if (min == Integer.MAX_VALUE)
            return -1;
        var ans = 0;
        for (var x : nums)
            if (x < min)
                ++ans;
        return ans;
    }

    int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
