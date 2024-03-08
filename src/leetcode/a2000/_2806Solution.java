package leetcode.a2000;
/**
 * 取整购买后的账户余额
 * {easy}
 */
public class _2806Solution {
   
    static final int START_AMOUNT = 100;

    public int accountBalanceAfterPurchase(int purchaseAmount) {
        return START_AMOUNT - (purchaseAmount + 5) / 10 * 10;
    }
}
