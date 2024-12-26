package leetcode.a3000;

/**
 * 对于数组中的元素，可以每次将元素除以小于它的最大正因子
 * 最少需要多少次，能够使得数组变成非递减序列
 * {greedy},{math}
 */
public class _3326Solution {

    /**
     * 数字只能变小，所以需要让右边尽可能大
     * 所以右边能不变就不变，只需要比更右侧大的时候再变小
     * 满足贪心规则
     * 如果不满足大小关系且是质数，那么就无法满足条件
     * @param nums
     * @return
     */
    public int minOperations(int[] nums) {

        if (nums.length == 1)
            return 0;
        int ops = 0;
        for (int i = nums.length - 2; i >= 0; i--) {

            int x = nums[i];
            while (x > nums[i + 1]) {
                int tmp = ops(x);
                if (tmp == -1)
                    return -1;
                x = tmp;
                ops++;

            }

            nums[i] = x;

        }
        return ops;
    }

    private int ops(int num) {

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return i;
        }

        return -1;
    }
}
