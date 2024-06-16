package leetcode.a400;

/**
 * 一组数组中所有数字的海明距离的和
 * {bit manuplation}
 */
public class _477Solution {

    /**
     * 逐位统计每一位中1的数量i,该位的总距离=i*(n-i)
     * 
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {

        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;

    }
}
