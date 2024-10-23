package leetcode.a3000;

/**
 * 位数相同的十进制数组中，对应位数字不相同的数对数量的总和
 * 
 */
public class _3153Solution {

    /**
     * 逐位进行统计，利用鸽巢原理，前面k个数减去与重复出现过的该数字
     * {bit manipulation},{pigeonhole}
     * @param nums
     * @return
     */
    public long sumDigitDifferences(int[] nums) {
        long ans = 0;
        int[][] cnt = new int[Integer.toString(nums[0]).length()][10];
        for (int k = 0; k < nums.length; k++) {
            // 逐个数字统计
            int x = nums[k];
            // 逐个数字，逐位统计和之前不同的数对的数目
            for (int i = 0; x > 0; x /= 10, i++) {
                ans += k - cnt[i][x % 10]++;
            }
        }
        return ans;
    }
}
