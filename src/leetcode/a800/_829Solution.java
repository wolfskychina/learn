package leetcode.a800;

/**
 * 连续整数和为n的可能方案数
 * {math}
 */
public class _829Solution {

    /**
     * 按照等差数列的长度遍历而不是起始数字
     * @param n
     * @return
     */
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        n *= 2;
        for (int k = 1; k * k < n; k++) {
            if (n % k != 0)
                continue;
            if ((n / k - (k - 1)) % 2 == 0)
                ans++;
        }
        return ans;
    }
}
