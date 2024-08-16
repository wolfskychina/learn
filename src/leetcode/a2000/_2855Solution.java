package leetcode.a2000;

import java.util.List;

/**
 * 使数组成为底层数组的最少右移次数
 * {easy}
 */
public class _2855Solution {

    public int minimumRightShifts(List<Integer> nums) {
        if (nums.size() == 1)
            return 0;
        boolean found = false;
        int i = 0;
        for (; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                found = true;
                break;
            }
        }
        if (found == false)
            return 0;
        int j = i + 1;
        while (j < nums.size() - 1) {
            if (nums.get(j) > nums.get(j + 1)) {
                return -1;
            }
            j++;
        }
        if (nums.get(0) > nums.get(nums.size() - 1)) {
            return nums.size() - 1 - i;
        } else {
            return -1;
        }
    }
}
