package leetcode.a900;
/**
 * 元素上下浮动k之后的最小差值
 * {easy}
 */
public class _908Solution {

    public int smallestRangeI(int[] nums, int k) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        max -= k;
        min += k;

        if (min >= max) {
            return 0;
        } else {
            return max - min;
        }

    }
}
