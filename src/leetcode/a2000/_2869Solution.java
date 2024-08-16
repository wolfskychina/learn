package leetcode.a2000;

import java.util.List;

/**
 * 收集元素的最少操作次数
 * {easy}
 */
public class _2869Solution {

    public int minOperations(List<Integer> nums, int k) {
        int i = nums.size() - 1;
        int remain = k;
        int count[] = new int[k + 1];

        for (; i >= 0; i--) {
            int j = nums.get(i);
            if (j > 0 && j <= k && count[j] == 0) {
                count[j] = -1;
                remain--;
                if (remain == 0)
                    return nums.size() - i;
            }
        }

        return -1;
    }
}
