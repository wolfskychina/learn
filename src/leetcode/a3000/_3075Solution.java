package leetcode.a3000;

import java.util.Arrays;

/**
 * 幸福值最大的选择方案
 * 每轮选择一个值之后，剩下的所有数的幸福值均减一
 * {math},{greedy}
 */
public class _3075Solution {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long res = 0;
        int step = 0;
        while (step < happiness.length && step < k) {
            if (happiness[happiness.length - step - 1] - step > 0) {

                res += happiness[happiness.length - step - 1] - step;
                step++;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _3075Solution so = new _3075Solution();
        int[] happiness = {12,1,42};
        so.maximumHappinessSum(happiness, 3);
    }
}
