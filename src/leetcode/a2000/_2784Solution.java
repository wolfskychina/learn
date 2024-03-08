package leetcode.a2000;
/**
 * 检查数组是否是好的
 * {easy}
 */
public class _2784Solution {

    public boolean isGood(int[] nums) {

        int[] count = new int[201];
        for (int i : nums) {
            count[i]++;
        }

        int n = nums.length - 1;
        int i = 1;
        for (; i < n; i++) {
            if (count[i] != 1)
                return false;
        }
        return count[i] == 2;
    }
}
