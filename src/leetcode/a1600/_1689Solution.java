package leetcode.a1600;

/**
 * 将一个数字拆成只包含0和1的数字之和
 * 求最少需要多少个这种数字
 * {greedy}
 */
public class _1689Solution {

    public int minPartitions1(String n) {

        boolean[] bit = new boolean[10];
        for (char c : n.toCharArray()) {

            bit[c - '0'] = true;
        }
        int last = 0;
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            if (bit[i]) {
                sum += i - last;
                last = i;
            }
        }
        return sum;
    }

    /**
     * 因为每个位每次最多只能提供+1，所以最少需要的数字
     * 应该是所有数位上数字的最大值
     * @param n
     * @return
     */
    public int minPartitions(String n) {

        boolean[] bit = new boolean[10];
        for (char c : n.toCharArray()) {

            bit[c - '0'] = true;
        }
        for (int i = 9; i > 0; i--) {
            if (bit[i]) {
                return i;
            }
        }
        return 0;
    }
}
