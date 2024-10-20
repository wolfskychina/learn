package leetcode.a2000;

/**
 * 最小异或
 * 按照num2中的1和0的个数，能够组成的和num1异或值最小的数
 */
public class _2429Solution {

    public int minimizeXor(int num1, int num2) {
        var c1 = Integer.bitCount(num1);
        var c2 = Integer.bitCount(num2);
        for (; c2 < c1; ++c2)
            num1 &= num1 - 1; // 最低的 1 变成 0
        for (; c2 > c1; --c2)
            num1 |= num1 + 1; // 最低的 0 变成 1
        return num1;
    }

}
