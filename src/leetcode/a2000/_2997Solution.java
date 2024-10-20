package leetcode.a2000;

/**
 * 使数组异或和等于K的最少操作次数
 * {bit manipulation}
 */
public class _2997Solution {

    public int minOperations(int[] nums, int k) {

        for (int i : nums) {

            k = k ^ i;
        }
        return Integer.bitCount(k);
    }
}
