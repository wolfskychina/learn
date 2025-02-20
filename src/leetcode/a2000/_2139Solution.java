package leetcode.a2000;

/**
 * 从1得到目标值的最少行动次数
 * 允许两种操作，单次加一或者单次*2，但是乘法最多只允许maxDouble次
 */
public class _2139Solution {

    /**
     * 逆向思维，从target反向操作最快得到1的次数
     * {reverse thinking},{greedy}
     * @param target
     * @param maxDoubles
     * @return
     */
    public int minMoves(int target, int maxDoubles) {
        int step = 0;
        while (target != 1) {
            if (target % 2 == 0 && maxDoubles != 0) {
                target >>= 1;
                maxDoubles--;
                step++;
            } else if (maxDoubles != 0) {
                target--;
                step++;
            } else {
                return step + target - 1;
            }
        }

        return step;
    }
}
