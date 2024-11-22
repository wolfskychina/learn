package leetcode.a2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到所有好下标
 * 好下标指下标i左侧相邻元素起至少连续k个元素为非递增，
 * 且右侧相邻元素起至少连续k个元素为非递减
 * {prefix sum}
 */
public class _2420Solution {

    /**
     * 所有位置某一侧相邻的最长非递增/递减序列可以使用一次遍历计算出来
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] dec = new int[n];
        Arrays.fill(dec, 1);
        for (int i = n - 2; i >= 1; i--) {
            if (nums[i] <= nums[i + 1])
                dec[i] = dec[i + 1] + 1;
        }
        int inc = 1;
        for (int i = 1; i < n - 1; i++) {
            if (inc >= k && dec[i + 1] >= k)
                res.add(i);
            if (nums[i - 1] >= nums[i])
                inc++;
            else
                inc = 1;
        }
        return res;
    }

}
