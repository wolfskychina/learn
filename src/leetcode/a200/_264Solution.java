package leetcode.a200;

/**
 * 返回第n大的丑数
 * {dp},{classic}
 */
public class _264Solution {

    /**
     * 所有的丑数都是从2,3，5几个元素不断乘出来的
     * TODO 已经乘过的序列不能再乘
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // p2,p3,p5是三个指针，指向已经算出来的前n-1个丑数中
        // 还没有新一轮*2,3,5的丑数
        // 最小生成指针
        // 相当于3个最小堆？
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            // 没有增长的下次继续参与比较，确保三个是候选项里面最小的三个
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
