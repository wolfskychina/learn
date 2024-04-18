package leetcode.lcr;

/**
 * 计算0-n之间所有整数的各自的比特位上1的个数
 * 要求on的时间复杂度
 * {dp},{bit manipulation}
 * 同338题
 */
public class Lcr003 {

    public int[] countBits1(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    /**
     * 根据奇偶性原理,奇数的1的个数比上一个数（偶数）多1
     * 偶数的1的个数和比他小1倍的偶数的1的数量相同
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                bits[i] = bits[i - 1] + 1;
            } else {
                bits[i] = bits[i >> 1];
            }
        }
        return bits;
    }
}
