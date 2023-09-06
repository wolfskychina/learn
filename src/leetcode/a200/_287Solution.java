package leetcode.a200;

/**
 * 整数数组总共有n个数，所有元素的取值都在[1,n-1]之间，
 * 数组中只有一个元素出现次数大于1，其他所有元素只
 * 出现了一次，求这个出现次数大于1的元素
 */
public class _287Solution {

    /**
     * 二分查找
     * 直接在解空间中[0,n-1]进行二分搜索
     * 对于每一个mid值，再遍历原数组，找到小于等于mid值的元素的个数count
     * 如果count大于mid值，说明存在比mid小的值，重复了两次或以上
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int len = nums.length; // n + 1 = len, n = len - 1

        // 在 [1,n+1) 查找 nums 中重复的元素
        int left = 1;
        int right = len;
        while (left < right) {
            int mid = (left + right) / 2;

            // nums 中小于等于 mid 的元素的个数
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                // 下一轮搜索的区间 [left..mid)
                right = mid;
            } else {
                // 下一轮搜索的区间 [mid + 1..right]
                left = mid + 1;
            }
        }
        return left;
    }
}
