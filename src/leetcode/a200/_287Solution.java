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
     * 采用猜数字的策略，速度比较慢
     * {binary search}
     * 
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

    /**
     * 更快的做法，但是违反了题目要求不能修改原数组的值
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        // O(n) O(n)
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    return nums[i];
                } else {
                    // 把不对的值换到对的位置
                    swap(nums, i, nums[i] - 1);
                }
            }
        }
        return -1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 快慢指针的方法
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        if(nums == null || nums.length ==0){
            return -1;
        }
        int slow =nums[0],fast=nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
