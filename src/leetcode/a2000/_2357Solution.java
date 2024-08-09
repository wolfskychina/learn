package leetcode.a2000;

import java.util.HashSet;
import java.util.Set;

/**
 * 每次从数组中减去最小的值直到所有数字都为0的最少次数
 * {easy}
 */
public class _2357Solution {

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }
        set.remove(0);
        return set.size();
    }
}
