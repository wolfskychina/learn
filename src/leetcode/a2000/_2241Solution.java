package leetcode.a2000;

/**
 * 设计笨atm机
 * 这种ATM机只能优先选取最大面额纸币，如果无法使用，则拒绝提供服务
 * {design},{greedy}
 */
public class _2241Solution {

    class ATM {
        private static final int[] DENOMINATIONS = { 20, 50, 100, 200, 500 };
        private static final int KINDS = DENOMINATIONS.length;

        private final int[] banknotes = new int[KINDS];

        public void deposit(int[] banknotesCount) {
            // 存钱
            for (int i = 0; i < KINDS; i++) {
                banknotes[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] ans = new int[KINDS];

            // 计算每种钞票所需数量
            for (int i = KINDS - 1; i >= 0; i--) {
                ans[i] = Math.min(amount / DENOMINATIONS[i], banknotes[i]);
                amount -= ans[i] * DENOMINATIONS[i];
            }

            // 无法取恰好 amount
            if (amount > 0) {
                return new int[] { -1 };
            }

            // 取钱
            for (int i = 0; i < KINDS; i++) {
                banknotes[i] -= ans[i];
            }

            return ans;
        }
    }
}
