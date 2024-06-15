package leetcode.a400;

/**
 * 求数字的反码
 * {bit manuplation}
 */
public class _476Solution {

    /**
     * 关键在于确定数字的二进制的位数
     * 同样长度的111做异或操作
     * 
     * @param num
     * @return
     */
    public int findComplement(int num) {
        long i = 1;
        // 注意相等的情况也要进位
        while (i <= num) {
            i = i << 1;
        }
        i--;
        return (int) i ^ num;

    }
    
}
