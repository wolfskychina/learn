package leetcode.a300;

/**
 * 打气球得分，每打爆一个气球可以获得气球本身上的数字和左右两个气球
 * 的数字的乘积，问能够获得的最大分数.
 */
public class _312Solution {

    /**
     * 把打气球的顺序反转，变成从空的面板（左右两边有虚拟的气球）
     * 增加气球得分，累计的结果是一样的
     * 增加气球可以很自然的变成dp问题
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                // 选择k作为分划点,rec[i][k]和rec[k][j]均为之前已经求出
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }

}
