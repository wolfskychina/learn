package leetcode.a2000;

import java.util.Arrays;

/**
 * 一个n元素的数组， 只记得数组元素值+k和元素值-k形成的数组（每个n个元素）
 * 里面的所有数（共2n个元素）
 * 不知道这些数是属于+k的数组还是-k得数组
 * 还原这个原始数组
 */
public class _2122Solution {

    /**
     * {slding window},{hard}
     * @param nums
     * @return
     */
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int m = nums.length;
        int[] ans = new int[m / 2];
        for (int i = 1; i < m; i++) {
            // nums[0] 必定是第一个值，用nums中的其他值枚举
            int diff = nums[i] - nums[0];
            // diff不为奇数和0
            if (diff % 2 == 1 || diff == 0)
                continue;
            int k = diff / 2;
            ans[0] = nums[0] + nums[i] >> 1;
            // 数组下标
            int idx = 1;
            // l从1开始
            int l = 1;
            // r从i+1开始 如果nums[i]为目标值的higher，那个下一个值+k 一定比nums[i]大
            int r = i + 1;
            boolean[] visited = new boolean[m];
            visited[i] = true;
            while (r < m) {
                // i+1后是没有被遍历过的，r遍历过的不能遍历，l遍历过的在l和r前面
                while (l < m && visited[l])
                    l++;
                // 需要大于2*k才可能
                // r不可能等于l
                while (r < m && nums[r] - nums[l] < 2 * k)
                    r++;
                // 边界 或者 大于2*k 则无效
                if (r == m || nums[r] - nums[l] > 2 * k)
                    break;
                // 发现一个原始值
                visited[r] = true;
                ans[idx] = nums[r] + nums[l] >> 1;
                idx++;
                l++;
                r++;
            }
            // 第一次满足，直接返回，lower[0]对应的higher[0]肯定是在比较前面的
            if (idx == m / 2)
                return ans;
        }
        return ans;
    }
}
