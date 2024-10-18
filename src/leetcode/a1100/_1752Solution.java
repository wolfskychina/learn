package leetcode.a1100;

/**
 * 检查数组是否是原来有序并且经历了一次拆分交换顺序的
 * {easy}
 */
public class _1752Solution {

    public boolean check(int[] nums) {

        if (nums.length == 1)
            return true;

        int i = 1;
        while (i < nums.length && nums[i] >= nums[i - 1])
            i++;

        if (i == nums.length)
            return true;

        for (int j = i, step = 0; step < nums.length - 1; step++) {

            if (nums[j] > nums[(j + 1) % nums.length])
                return false;

            j = (j + 1) % nums.length;
        }

        return true;
    }
}
