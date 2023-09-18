package leetcode.a300;
/**
 * 342. Power of Four
 * 判断一个数不是不是4的幂
 */
public class _342Solution {
    
    /**
     * n首先是2的幂，然后2的幂有一半是4的幂，一半不是
     * 只有mod3余数为1的才是4的幂
     * 另外一个性质是：乘模运算符合结合律
     * @param n
     * @return
     */
    public boolean isPowerOfFour(int n) {

        return (n>0)&&((n&(n-1)) == 0)&&(n%3==1);
    }

    /**
     * 4的幂的二进制的特点是只在偶数位有一个1
     * 可以构建一个所有偶数位都是1的掩码，和n进行与运算
     * @param n
     * @return
     */
    public boolean isPowerOfFour2(int n) {
        // (10101010..10)2,用16进制表示是0xaaaaaaaa
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

}
