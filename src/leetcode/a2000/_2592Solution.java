package leetcode.a2000;

import java.util.Arrays;

/**
 * 最大化数组的伟大值
 * 将数组重排后跟原数组对应元素比较，值更大的对数的最大值是多少
 * {greedy},{sorting},{two pointers}
 */
public class _2592Solution {

    /**
     * 田忌赛马
     * 双指针，每次都拿最小的更大值去匹配
     * @param nums
     * @return
     */
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (int x : nums)
            if (x > nums[i])
                ++i;
        return i;
    }

}
