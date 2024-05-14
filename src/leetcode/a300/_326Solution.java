package leetcode.a300;

/**
 * 判断一个数是不是3的幂
 * {math}
 */
public class _326Solution {

    /**
     * 3的幂
     * 
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        long i = 1;
        while (i <= n) {
            if (i == n)
                return true;
            i *= 3;
        }

        return false;
    }

    /**
     * 3的19次方是整数范围内最大的3的幂
     * 只需要判断n是不是这个数的约数即可
     * 
     * @param n
     * @return
     */
    public boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
