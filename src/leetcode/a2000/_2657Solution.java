package leetcode.a2000;

/**
 * 找到两个数组的前缀数组
 * 前i位中出现的数字相同的次数定义为前缀数
 */
public class _2657Solution {

    /**
     * 使用bit位存储出现过的数字，注意long型的计算
     * {bit manipulation}
     */
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        long pre1 = 0;
        long pre2 = 0;
        int res[] = new int[A.length];

        for (int i = 0; i < A.length; i++) {

            // 注意右侧不加L的话会默认按照int型计算，导致溢出
            // TODO 
            pre1 |= 1L << A[i];
            pre2 |= 1L << B[i];
            res[i] = Long.bitCount(pre1 & pre2);
        }

        return res;
    }
}
