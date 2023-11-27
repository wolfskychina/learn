package leetcode.a700;
/**
 * 一个以0为结尾的二进制编码数组中，有两种编码
 * 一种是单个位的0
 * 一种是两个位的编码，分别有10,11两种
 * 问这个数组的最后一位的0，能否确定是单个位的编码
 */
public class _717Solution {

    /**
     * 遍历到最后两位
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {

        if (bits.length == 1)
            return true;
        if (bits.length == 2) {
            if (bits[bits.length - 2] == 1)
                return false;
            return true;
        }

        int i = 0;
        while (i < bits.length - 2) {
            if (bits[i] == 0)
                i++;
            else
                i += 2;
        }

        if (i == bits.length - 1)
            return true;
        if (bits[i] == 1)
            return false;
        return true;

    }
}
