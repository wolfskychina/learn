package leetcode.a1500;

import java.util.Arrays;

/**
 * 给定一些区间，允许nums元素以任意形式排列
 * 对于所有可能的排列，这些固定区间的区间和最大可能是多少？
 * {delta counting}
 */
public class _1589Solution {

    public int maxSumRangeQuery(int[] nums, int[][] requests) {

        // counting
        int count[] = new int[nums.length + 1];
        for (int[] req : requests) {
            count[req[0]]++;
            count[req[1] + 1]--;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        Arrays.sort(count);
        Arrays.sort(nums);
        int i = count.length - 1;
        int j = nums.length - 1;
        long res = 0;
        int MOD = (int) 1e9 + 7;
        while (count[i] != 0) {
            // 注意中间值用long转换，避免精度不足
            res = (res + (long) count[i--] * nums[j--]) % MOD;
        }

        return (int) res % MOD;

    }
}
