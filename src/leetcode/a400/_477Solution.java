package leetcode.a400;
/**
 * 一组数组中所有数字的海明距离的和
 */
public class _477Solution {

    /**
     * 逐位统计每一位中1的数量i,该位的总距离=i*(n-i)
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {

        int res = 0;
        int n = nums.length;
        for (int i = 0; i < 31; i++) {
            int numOf1 = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    numOf1++;
                }
            }

            res += numOf1 * (n - numOf1);
        }

        return res;

    }
}
