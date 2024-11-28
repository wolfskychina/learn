package leetcode.a900;

import java.util.HashMap;
import java.util.Map;

/**
 * 元素和等于t的二进制子数组的数量
 * 前缀和求解子区间和的问题
 * TODO
 */
public class _930Solution {

    /**
     * {prefix sum}
     * 记录左边出现过的前缀和，根据差去hashmap里面查找
     * 空间换时间
     * 
     * @param nums
     * @param t
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int t) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int r = sum[i + 1], l = r - t;
            ans += map.getOrDefault(l, 0);
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        return ans;
    }

    /**
     * {sliding window},{two pointers}
     * 因为元素只包括非负整数，所以可以固定右侧端点的情况下，左侧符合条件
     * 的左右边界，l1,l2,[l1,r]和[l2,r]的区间和相同，说明[l1,l2]之间都是0
     * 
     * @param nums
     * @param t
     * @return
     */
    public int numSubarraysWithSum1(int[] nums, int t) {
        int n = nums.length;
        int ans = 0;
        for (int r = 0, l1 = 0, l2 = 0, s1 = 0, s2 = 0; r < n; r++) {
            s1 += nums[r];
            s2 += nums[r];
            // 以r为右端点的区间和为t的子数组的最左侧端点
            while (l1 <= r && s1 > t)
                s1 -= nums[l1++];
            // 以r为左端点的区间和为t的子数组的最右侧端点+1
            while (l2 <= r && s2 >= t)
                s2 -= nums[l2++];
            ans += l2 - l1;
        }
        return ans;
    }

}
