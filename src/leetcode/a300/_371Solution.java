package leetcode.a300;

/**
 * 两数之和
 * 要求不能用系统自带的加法
 * {bit manipulation}
 * TODO
 */
public class _371Solution {

    /**
     * 利用两个数异或可以算出不带进位的和
     * 哪些位会产生进位可以通过&运算，向左移一位就会得到进位产生需要+1的位
     * 重复以上直至需要累加得进位为0
     * 
     * 
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;

    }
}
