package leetcode.a1300;

/**
 * 统计作战单位数
 * 统计数组中满足x1<x2<x3或者x1>x2>x3的三元组的数量
 * 数组中所有数字大小均不相等
 */
public class _1395Solution {

    /**
     * {dp}
     * dp定义比较关键，dp[i][x]表示第i个元素作为第x大元素的个数
     * 空间换时间的思路
     * 
     * @param rating
     * @return
     */
    public int numTeams(int[] rating) {

        int ret = 0;
        int len = rating.length;

        int dp1[][] = new int[len+1][4];
        int dp2[][] = new int[len+1][4];

        for (int i = 0; i < len; ++i)
            dp1[i][1] = dp2[i][1] = 1;

        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (rating[i] > rating[j]) {
                    dp1[i][2] += dp1[j][1];
                    dp1[i][3] += dp1[j][2];
                }
                if (rating[i] < rating[j]) {
                    dp2[i][2] += dp2[j][1];
                    dp2[i][3] += dp2[j][2];
                }
            }
        }
        for (int i = 0; i < len; ++i) {
            ret += dp1[i][3] + dp2[i][3];
        }
        return ret;

    }
}