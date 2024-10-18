package leetcode.a1400;

/**
 * 逐步求和得到de正数的最小值
 * {easy}
 */
public class _1413Solution {

    public int minStartValue(int[] nums) {

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            min = Math.min(min, sum);
        }
        int res = 1 - min;
        return res <= 0 ? 1 : res;
    }
}
