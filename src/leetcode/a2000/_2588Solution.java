package leetcode.a2000;

import java.util.HashMap;

/**
 * 元素异或之和等于0的子数组的数量
 * {bit manipulation},{prefix sum},{hash}
 */
public class _2588Solution {

    public long beautifulSubarrays(int[] nums) {
        long ans = 0;
        int n = nums.length;
        var s = new int[n + 1];
        // s[0]=0需要统计因为计算整个数组异或时需要
        for (int i = 0; i < n; ++i)
            s[i + 1] = s[i] ^ nums[i];
        var cnt = new HashMap<Integer, Integer>();
        for (int x : s) {
            // 先计入答案再统计个数，如果反过来的话，就相当于把空子数组也计入答案了
            ans += cnt.getOrDefault(x, 0);
            cnt.merge(x, 1, Integer::sum);
        }
        return ans;
    }
}
