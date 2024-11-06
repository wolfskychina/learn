package leetcode.a3000;

import java.util.Arrays;

/**
 * 长度为k的所有子数组的value
 * value定义为如果子数组中数字是连续递增，那么value为最大的值
 * 否则是value是-1
 * {sliding window}
 */
public class _3254Solution {

    /**
     * 属于滑动窗口的思路但是不是定长滑动窗口
     * 题意容易造成误导，实际上滑动的时候统计最长连续上升序列
     * 如果长度大于等于k了就记录到对应的结果位置上即可
     * @param nums
     * @param k
     * @return
     */
    public int[] resultsArray(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Arrays.fill(ans, -1);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt = i == 0 || nums[i] == nums[i - 1] + 1 ? cnt + 1 : 1;
            if (cnt >= k) {
                ans[i - k + 1] = nums[i];
            }
        }
        return ans;
    }

}
