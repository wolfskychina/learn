package leetcode.a2000;

/**
 * 得到0需要的操作次数
 */
public class _2169Solution {

    public int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 < num2) {
                num2 -= num1;
            } else {
                num1 -= num2;
            }
            count++;
        }
        return count;

    }

    /**
     * 直接用余数求出倍数差，更快
     * @param num1
     * @param num2
     * @return
     */
    public int countOperations1(int num1, int num2) {
        int ans = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                ans += num1 / num2;
                num1 %= num2;
            } else {
                ans += num2 / num1;
                num2 %= num1;
            }
        }
        return ans;
    }
}
