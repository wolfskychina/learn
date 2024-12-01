package leetcode.a2000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 相等值的元素的坐标绝对值之和
 * {prefix sum}
 * 
 */
public class _2615Solution {

    /**
     * TODO 20241129 prefix sum
     * 相等值的元素归类记录坐标，然后使用前缀和计算
     * 
     * @param nums
     * @return
     */
    public long[] distance(int[] nums) {

        int n = nums.length;
        var groups = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; ++i) // 相同元素分到同一组，记录下标
            groups.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);

        var ans = new long[n];
        var s = new long[n + 1];
        for (var a : groups.values()) {
            int m = a.size();
            for (int i = 0; i < m; ++i)
                s[i + 1] = s[i] + a.get(i); // 前缀和
            for (int i = 0; i < m; ++i) {
                int target = a.get(i);
                long left = (long) target * i - s[i]; // 蓝色面积
                long right = s[m] - s[i] - (long) target * (m - i); // 绿色面积
                ans[target] = left + right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        _2615Solution so = new _2615Solution();
        int[] nums = { 1, 3, 1, 1, 2 };
        so.distance(nums);
    }
}
