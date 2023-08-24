package leetcode.a300;

/**
 * 两个只出现一次的整数
 * 一个整数序列，除了两个数只出现了一次，其他数都恰好出现两次
 */
public class _260Solution {
    /**
     * 容易找到这两个数异或的结果a
     * 然后这个结果a的各个位中，至少有一位是1（因为两个数不相同）
     * 根据某个不相同的位，可以把原来的数组分成两份
     * 其中，这两个出现一次的数，一定在两边
     * 同时，出现两次的数，相同的数一定在同一边
     * 这样，问题就变成了每个数字中只有一个出现过一次的数
     */
    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }
        // 防止溢出
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[]{type1, type2};
    }
}
