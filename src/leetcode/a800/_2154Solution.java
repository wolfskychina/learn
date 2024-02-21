package leetcode.a800;

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
}
