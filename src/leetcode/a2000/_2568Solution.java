package leetcode.a2000;

import java.util.HashSet;

/**
 * 最小无法得到的或值
 * 给定一组数，这些数字任意组合或操作之后，所无法组成的最小数字是多少
 * {bit manipulation}
 */
public class _2568Solution {

    /**
     * 如果 1 不是答案，说明 1 在 nums 中，因为 1 只有一个比特是 1（下同）。
     * 继续枚举，如果 2 不是答案，说明 2 在 nums 中。
     * 那么 3 肯定不是答案，因为 1 和 2 都在 nums 中，且 1∣2=3。
     * 继续枚举，如果 4 不是答案，说明 4 在 nums 中。
     * 那么 5,6,7 肯定不是答案，因为 1,2,4 都在 nums 中，它们可以通过或运算组成 1 到 7 中的任意数字。
     * 
     * @param nums
     * @return
     */
    public int minImpossibleOR1(int[] nums) {
        var s = new HashSet<Integer>();
        for (int x : nums)
            s.add(x);
        for (int i = 1;; i <<= 1)
            if (!s.contains(i))
                return i;
    }

    /**
     * 最小不存在的数一定是2的幂次
     * @param nums
     * @return
     */
    public int minImpossibleOR(int[] nums) {
        int mask = 0;
        for (int x : nums)
            if ((x & (x - 1)) == 0) // x 是 2 的幂次
                mask |= x;
        mask = ~mask;
        return mask & -mask; // lowbit

    }
}
