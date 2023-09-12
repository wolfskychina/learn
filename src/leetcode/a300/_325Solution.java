package leetcode.a300;

import java.util.HashMap;
import java.util.Map;
/**
 * nums的子区间的元素之和=k，求这样最长的子区间
 * 如果没有，返回0；
 */
public class _325Solution {

    /**
     * 根据不同的前缀和作差，可以知道任意区间的和
     * 前缀和可以一趟循环全部做出来
     * 使用hashmap保存每一个不同的前缀和的值的坐标（如果某一个前缀和有多个坐标，那么保留
     * 最左侧的坐标
     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        // 哈希表，映射前缀和值到第一次出现的下标位置
        Map<Integer, Integer> preSumIndex = new HashMap<>();
        int ans = 0;
        // 前缀和
        int preSum = 0;
        // 0 出现的位置在 -1 位置处
        preSumIndex.put(0, -1);
        // 特殊的情况，某个单独的前缀和构成了k大小
        // 这个时候不是两个前缀和的差，而是一个前缀和的值
        // 除了这种特殊情况，其他的和a+b=sum两数之和原理相同
        for (int i = 0; i < n; ++i) {
            // 累加前缀和
            preSum += nums[i];
            // 确保记录的是第一次出现的位置
            if (!preSumIndex.containsKey(preSum)) {
                preSumIndex.put(preSum, i);
            }
            // 检查一下是否需要更新答案
            if (preSumIndex.containsKey(preSum - k)) {
                ans = Math.max(ans, i - preSumIndex.get(preSum - k));
            }
        }
        return ans;
    }

}
