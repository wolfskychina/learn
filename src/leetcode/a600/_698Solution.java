package leetcode.a600;

import java.util.Arrays;
/**
 * 能否将nums数组里面的数字分到k个桶里面，使得每个桶里面的数字和相同
 */
public class _698Solution {

    /**
     * {backtrack},{dfs}共有k层递归,对解空间进行搜索
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % k != 0)
            return false;
        int target = sum / k;
        // 排序优化
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return backtrack(nums, 0, new int[k], k, target);
    }

    private boolean backtrack(int[] nums, int index, int[] bucket, int k, int target) {
        // 结束条件优化
        if (index == nums.length)
            return true;
        for (int i = 0; i < k; i++) {
            // 优化点二
            // 避免重复答案
            if (i > 0 && bucket[i] == bucket[i - 1])
                continue;
            // 剪枝
            if (bucket[i] + nums[index] > target)
                continue;
            bucket[i] += nums[index];
            if (backtrack(nums, index + 1, bucket, k, target))
                return true;
            bucket[i] -= nums[index];
        }
        return false;
    }

    public static void main(String[] args) {
        _698Solution so = new _698Solution();
        int[] nums = { 1, 1, 1, 1, 2, 2, 2, 2 };
        so.canPartitionKSubsets(nums, 4);

    }

}
