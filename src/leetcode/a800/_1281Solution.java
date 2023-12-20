package leetcode.a800;
/**
 * 整数的各位数字的积与和的差
 */
public class _1281Solution {

    /**
     * {easy}
     * @param n
     * @return
     */
    public int subtractProductAndSum(int n) {
        int pro = 1;
        int sum = 0;
        if (n == 0)
            return 0;

        while (n != 0) {
            pro *= n % 10;
            sum += n % 10;
            n = n / 10;
        }
        return pro - sum;

    }
}
