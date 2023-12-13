package leetcode.a100;
/**
 * 一个数组中的数字除了一个只出现过1次，其他的都恰好出现了3次
 * 求这个出现了一次的数字
 */
public class _137Solution {

    /**
     * {bit manipulation}统计每一位出现的次数，然后mod3
     * 余数是1的位数是出现一次的数字的位数
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;

        }
        res >>= 1;
        return res;
    }
}
