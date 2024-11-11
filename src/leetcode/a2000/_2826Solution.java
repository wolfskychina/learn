package leetcode.a2000;

import java.util.List;

/**
 * 只含123三种数字的数组，最少删除多少个元素，能使得剩下的元素保持非降序
 * {dp},{lis}
 */
public class _2826Solution {

    public int minimumOperations(List<Integer> nums) {

        int f1 = 0;
        int f2 = 0;
        int f3 = 0;
        for (int i : nums) {
            if (i == 1) {
                f1++;
            } else if (i == 2) {
                f2 = Math.max(f1, f2) + 1;
            } else {
                f3 = Math.max(f1, Math.max(f2, f3)) + 1;
            }
        }

        return nums.size() - Math.max(f1, Math.max(f2, f3));
    }
}
