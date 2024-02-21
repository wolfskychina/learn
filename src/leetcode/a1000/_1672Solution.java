package leetcode.a1000;
/**
 * 最富有客户的资金总量
 * {easy}
 */
public class _1672Solution {

    public int maximumWealth(int[][] accounts) {

        int max = 0;
        for (int j = 0; j < accounts.length; j++) {

            for (int i = accounts[0].length - 1; i > 0; i--) {

                accounts[j][0] += accounts[j][i];

            }

            max = Math.max(max, accounts[j][0]);

        }
        return max;

    }
}
