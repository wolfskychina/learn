package leetcode.a900;

/**
 * 坏了的计算器
 * 只能进行两种操作，使当前数*2或者当前数-1
 * 求至少要多少次操作能使startValue变成target
 * {greedy},{reverse thinking}
 */
public class _991Solution {

    /**
     * 自己的方法耗时很长
     * @param startValue
     * @param target
     * @return
     */
    public int brokenCalc1(int startValue, int target) {

        int step = 0;

        // 主要是需要统计所有的+1操作比较耗时
        while (target != startValue) {
            if (((target & 1) == 0) && startValue < target) {

                target /= 2;
            } else {
                target += 1;
            }
            step++;
        }

        return step;
    }

    public int brokenCalc(int startValue, int target) {
        int count = 0;
        // 统计完所有的/2操作之后
        // 剩下的所有+1操作可以直接算出来
        while (target > startValue) {
            if (target % 2 == 0) {
                target /= 2;
            } else {
                target++;
            }
            count++;
        }
        return count + (startValue - target);
    }
}
