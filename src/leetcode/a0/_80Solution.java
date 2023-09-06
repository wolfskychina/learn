package leetcode.a0;

/**
 * 去掉有序数组中的重复元素，使得结果数组中每个不同的元素最多出现两次。
 */
public class _80Solution {
   
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}
