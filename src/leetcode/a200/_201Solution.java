package leetcode.a200;

/**
 * n个连续整数的AND结果
 * {bit manuplation}
 */
public class _201Solution {

    /**
     * 首先，将所有数AND一遍会超时
     * 自己观察的一个规律
     * 每一位i，0和1出现的规律都是2的i次方个0和2的i次方个1交替出现
     * 只有区间全部落在1出现的范围内，该位才可能是1，否则至少有一个0，该位就是0
     * 
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {

        int res = 0;

        for (int i = 31; i >= 0; i--) {
            if ((left >> i) % 2 == 0) {
                res = res << 1;
            } else if ((left % (1 << i) + right - left) < (1 << i)) {
                // TODO 注意位操作的优先级很低，需要加括号
                res = (res << 1) + 1;
            } else {
                res = res << 1;
            }
        }

        return res;
    }

    /**
     * 另一种解法，求解left和right的最长相同前缀
     * 因为后面不相同的位，一定是有0和有1，只要有0那么该位最后就是0
     * 
     * @param args
     */

    public static void main(String[] args) {

        _201Solution so = new _201Solution();
        // System.out.println(so.rangeBitwiseAnd(0, 1));
        // System.out.println(so.rangeBitwiseAnd(1, Integer.MAX_VALUE));
        System.out.println(so.rangeBitwiseAnd(6, 7));
    }
}
