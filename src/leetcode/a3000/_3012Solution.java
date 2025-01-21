package leetcode.a3000;

/**
 * 通过操作使得一开始全部为正整数的数组最终的长度最小
 * 每次操作可以任选两个正整数，然后取余，将这两个数从数组中移除
 * 将余数添加到数组中，直到最终无法继续操作为止
 * 
 * {math},{mod}
 */
public class _3012Solution {

    /**
     * 如果最小数只有一个，那么可以用这个数mod其他所有数，让其他数都被移除
     * 最终剩下这个数
     * 如果最小数min不止有1个，那么如果有不是min倍数的数，那么min和这个数
     * 可以生成一个更小的数，用这个更小的数mod剩下的数，最终结果也是1个
     * 如果其余所有的数都是min的倍数，那么只能将其他的数移除，
     * 最终min之间两两消除变成一个0，最终剩numOf(min)+1 / 2个0
     * @param nums
     * @return
     */
    public int minimumArrayLength(int[] nums) {
        int m = Integer.MAX_VALUE;
        for (int x : nums) {
            m = Math.min(m, x);
        }

        for (int x : nums) {
            if (x % m > 0) {
                return 1;
            }
        }

        int cnt = 0;
        for (int x : nums) {
            if (x == m) {
                cnt++;
            }
        }
        return (cnt + 1) / 2;
    }
}
