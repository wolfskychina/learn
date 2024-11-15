package leetcode.a1000;

import java.util.Arrays;

/**
 * 数组中的最长等差数列序列的长度
 */
public class _1027Solution {

    /**
     * {dp}
     * TODO\
     * 记 f[i][d][num] 表示使用数组 nums 中下标小于等于 i 的元素，
     * 构造公差为 d 的等差数列，并且最后一个元素为 num 时，等差数列长度的最大值。
     * 
     * @param nums
     * @return
     */
    public int longestArithSeqLength(int[] nums) {
        int minv = Arrays.stream(nums).min().getAsInt();
        int maxv = Arrays.stream(nums).max().getAsInt();
        int diff = maxv - minv;
        int ans = 1;
        for (int d = -diff; d <= diff; ++d) {
            int[] f = new int[maxv + 1];
            Arrays.fill(f, -1);
            for (int num : nums) {
                int prev = num - d;
                if (prev >= minv && prev <= maxv && f[prev] != -1) {
                    f[num] = Math.max(f[num], f[prev] + 1);
                    ans = Math.max(ans, f[num]);
                }
                // 如果是1，说明f[num]是等差数列的第一个元素
                // 元素num要么是之前数列的后继元素，要么是开头的元素
                f[num] = Math.max(f[num], 1);
            }
        }
        return ans;
    }
}
