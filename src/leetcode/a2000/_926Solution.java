package leetcode.a2000;

/**
 * 让二进制字符串变成非递减二进制串所需要的最少操作
 * 比如0000，1111，0011
 * {prefix sum}
 */
public class _926Solution {

    /**
     * 假设第i位是非递减序列的转折点，该位是0或者1都行，因此不需要flip
     * 转折点前面必须全是0，后面必须全是1
     * 那么以该位为转折点的最少flip次数就是前面需要反转的最小次数加后面需要
     * 反转的最小次数
     * @param s
     * @return
     */
    public int minFlipsMonoIncr(String s) {

        char[] cs = s.toCharArray();
        int n = cs.length, ans = n;
        int[] sum = new int[n + 10];

        for (int i = 1; i <= n; i++)
            sum[i] = sum[i - 1] + (cs[i - 1] - '0');

        for (int i = 1; i <= n; i++) {
            int l = sum[i - 1], r = (n - i) - (sum[n] - sum[i]);
            ans = Math.min(ans, l + r);
        }

        return ans;
    }

}
