package leetcode.a3000;

/**
 * 超过阈值的最小操作数
 * {easy}
 */
public class _3065Solution {

    public int minOperations(int[] nums, int k) {

        int count = 0;

        for (int i : nums) {

            if (i < k)
                count++;
        }
        return count;
    }
}
