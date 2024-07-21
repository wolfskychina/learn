package leetcode.a100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * nums是已经排好序的数组，所有的元素大小都在[lower,upper]之间
 * 返回不含nums中所有元素的按照大小排序的最小区间
 * {easy}
 */
public class _163Solution {

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> ranges = new ArrayList<>();

        // 遍历nums中的数字
        for (int num : nums) {
            if (lower < num) {
                // 将区间[lower, num-1]添加进结果集
                ranges.add(Arrays.asList(lower, num - 1));
            }
            lower = num + 1;
        }

        // 遍历完nums之后 如果发现lower依然小于upper
        // 说明这段是缺失的，添加进结果集
        if (lower <= upper) {
            ranges.add(Arrays.asList(lower, upper));
        }

        return ranges;
    }

}
