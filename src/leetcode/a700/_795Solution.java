package leetcode.a700;
/**
 * 区间子数组的个数
 * 满足条件的子数组必须包含[left,right]之间大小的数，不能包含>right的数，其他的数
 * 没有限制
 * {two pointers}
 */
public class _795Solution {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0, last2 = -1, last1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last2 = i;
                last1 = -1;
            }
            if (last1 != -1) {
                // 很巧妙的对应两种情况
                // last1是之前值
                // last1是当前i值
                res += last1 - last2;
            }
        }
        return res;
    }
}
