package leetcode.a400;
/**
 * 给定一个数组，返回数组中非重复的第3大的数字
 */
public class _414Solution {

    public int thirdMax(int[] nums) {

        // 注意nums中的最小值可能取到Integer.MIN_VALUE
        long f = Long.MIN_VALUE;
        long s = Long.MIN_VALUE;
        long t = Long.MIN_VALUE;

        for (int i : nums) {
            if (i == f || i == s || i == t) {
                continue;
            } else if (i > f) {
                t = s;
                s = f;
                f = i;
            } else if (i > s) {
                t = s;
                s = i;
            } else if (i > t) {
                t = i;
            }
        }

        return t == Long.MIN_VALUE ? (int) f : (int) t;

    }
}
