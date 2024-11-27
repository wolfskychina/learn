package leetcode.a3000;

/**
 * 判断数组的子数组是否满足所有相邻元素的奇偶性相反
 */
public class _3152Solution {

    /**
     * {prefix sum},将相邻元素相同记为1，不同记为0
     * 那么前缀和为0的话就代表全部的相邻元素奇偶性均不同，如果不是0则说明里面
     * 有奇偶性不同的相邻元素
     * TODO 问题转换比较巧妙
     * @param nums
     * @param queries
     * @return
     */
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] s = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            s[i] = s[i - 1] + (nums[i - 1] % 2 == nums[i] % 2 ? 1 : 0);
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            // 区间前缀和没有增加，说明奇偶性依次出现没有连续相同的奇偶性
            ans[i] = s[q[0]] == s[q[1]];
        }
        return ans;
    }

    public static void main(String[] args) {

        _3152Solution so = new _3152Solution();
        int[] nums = { 3, 7, 8 };
        int[][] queries = { { 0, 2 } };
        so.isArraySpecial(nums, queries);
    }
}
