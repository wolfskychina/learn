package leetcode.a3000;

import java.util.Arrays;

/**
 * 数组中的每个数字都可以最多往+-k的方向移动一次
 * 问最后数组中不相同的数字最多有多少
 */
public class _3397Solution {

    /**
     * {greedy}
     * @param nums
     * @param k
     * @return
     */
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int pre = Integer.MIN_VALUE; // 记录每个人左边的人的位置
        // 关键在于这个位置，x的最终位置必须在[x-k,x+k]中，如果pre+1在区间中
        // 一定会落在pre+1上，如果pre+1在x+k的右边，说明x和左边数相等且可用区间已经填满
        // 此时无法避免重复，非重复数不能+1
        for (int x : nums) {
            x = Math.min(Math.max(x - k, pre + 1), x + k);
            if (x > pre) {
                ans++;
                pre = x;
            }
        }
        return ans;
    }
}
