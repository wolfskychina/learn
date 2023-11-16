package leetcode.a600;
/**
 * 找到序列中出现错误的数字
 * {easy}
 */
public class _645Solution {

    public int[] findErrorNums(int[] nums) {
        int num1 = 0;
        int num2 = 0;

        boolean count[] = new boolean[nums.length + 1];
        for (int i : nums) {
            if (count[i]) {
                num1 = i;
            } else {
                count[i] = true;
            }
        }

        for (int i = 1; i < count.length; i++) {
            if (!count[i]) {
                num2 = i;
            }
        }

        return new int[] { num1, num2 };
    }
}
