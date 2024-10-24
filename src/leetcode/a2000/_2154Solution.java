package leetcode.a2000;

import java.util.HashSet;
import java.util.Set;

/**
 * 寻找放大两倍后仍然在数组中的数字
 * {easy}
 */
public class _2154Solution {

    public int findFinalValue(int[] nums, int original) {

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        while (true) {

            if (set.contains(original)) {
                original = original * 2;
            } else {
                return original;
            }
        }
    }

    /**
     * {bit manipulation}
     * 
     * @param nums
     * @param original
     * @return
     */
    public int findFinalValue1(int[] nums, int original) {

        int mask = 0;
        for (int num : nums) {
            if (num % original == 0) {
                int k = num / original; // 倍数
                if ((k & (k - 1)) == 0) { // 倍数是 2 的幂次
                    mask |= k;
                }
            }
        }
        mask = ~mask; // 取反后，找最低位的 1（lowbit = mask & -mask）
        // 或者直接计算 ~mask & (mask+1) 最低位的1
        return original * (mask & -mask);
    }
}
