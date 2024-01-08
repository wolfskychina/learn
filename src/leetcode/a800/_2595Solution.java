package leetcode.a800;
/**
 * 数字的二进制表示的奇偶位上的1分别的数目
 * {easy}
 */
public class _2595Solution {
   
    public int[] evenOddBit(int n) {
        var ans = new int[2];
        for (int i = 0; n > 0; i ^= 1, n >>= 1)
            ans[i] += n & 1;
        return ans;
    }
}
