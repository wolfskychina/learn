package leetcode.a2000;

/**
 * 长度为k的子数组中的所有美丽值
 * 美丽值是子数组中第x小的数，且为负数，否则是0
 */
public class _2653Solution {

    /**
     * 因为元素的大小为正负50，所以可以直接用count数组
     * {sliding window},{subarray}
     * @param nums
     * @param k
     * @param x
     * @return
     */
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        final int BIAS = 50;
        var cnt = new int[BIAS * 2 + 1];
        int n = nums.length;
        for (int i = 0; i < k - 1; ++i) // 先往窗口内添加 k-1 个数
            ++cnt[nums[i] + BIAS];
        var ans = new int[n - k + 1];
        for (int i = k - 1; i < n; ++i) {
            ++cnt[nums[i] + BIAS]; // 进入窗口（保证窗口有恰好 k 个数）
            int left = x;
            for (int j = 0; j < BIAS; ++j) { // 暴力枚举负数范围 [-50,-1]
                left -= cnt[j];
                if (left <= 0) { // 找到美丽值
                    ans[i - k + 1] = j - BIAS;
                    break;
                }
            }
            --cnt[nums[i - k + 1] + BIAS]; // 离开窗口
        }
        return ans;
    }
}
