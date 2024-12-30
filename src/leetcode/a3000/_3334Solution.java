package leetcode.a3000;

/**
 * 数组的最大因子得分指
 * 最多去掉一个元素的条件下，数组所有元素的最大公约数和最小公倍数的乘积
 * 最大时多少
 * {gcd},{math},{prfix sum}
 */
public class _3334Solution {

    public long maxScore(int[] nums) {
        int n = nums.length;
        int[] sufGcd = new int[n + 1];
        long[] sufLcm = new long[n + 1];
        sufLcm[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            sufGcd[i] = (int) gcd(sufGcd[i + 1], nums[i]);
            sufLcm[i] = lcm(sufLcm[i + 1], nums[i]);
        }

        long ans = sufGcd[0] * sufLcm[0]; // 不移除元素
        int preGcd = 0;
        long preLcm = 1;
        for (int i = 0; i < n; i++) { // 枚举移除 nums[i]
            ans = Math.max(ans, gcd(preGcd, sufGcd[i + 1]) * lcm(preLcm, sufLcm[i + 1]));
            preGcd = (int) gcd(preGcd, nums[i]);
            preLcm = lcm(preLcm, nums[i]);
        }
        return ans;
    }

    private long gcd(long a, long b) {
        while (a != 0) {
            long tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
