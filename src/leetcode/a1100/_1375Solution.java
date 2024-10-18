package leetcode.a1100;
/**
 * 二进制字符串前缀一致的次数
 * 1-n的数字的一个乱序排列X，根据这各排列依次将第i位的0变成1
 * 问一共有多少种i，当反转i之后，二进制字符串恰好前i位是1，后面的位全是0
 */
public class _1375Solution {

    /**
     * 当判断第i位时，需要关心的只是前i+1位的1的个数（从而判断是不是全是0）
     * 和第i位的数是不是1，i位以后的数不需要判断，但是如果出现了反转成1，需要记录
     * 以便以后的遍历进行判断
     * @param flips
     * @return
     */
    public int numTimesAllBlue(int[] flips) {

        int num[] = new int[flips.length];

        int prefix = 0;
        int require = 1;
        int count = 0;
        for (int i = 0; i < flips.length; i++) {

            if (flips[i] - 1 < i) {
                prefix++;
                if (num[i] == 1) {
                    prefix++;
                    if (prefix == require) {
                        count++;
                    }
                }
            } else if (flips[i] - 1 == i) {

                prefix++;
                if (prefix == require)
                    count++;
            } else {
                // flips[i]-1>i
                num[flips[i] - 1] = 1;
                if (num[i] == 1) {
                    prefix++;
                }
            }

            require++;
        }

        return count;
    }

    public static void main(String[] args){

        _1375Solution so  = new _1375Solution();
        int [] flips = {3,2,4,1,5};
        so.numTimesAllBlue(flips);
    }
}
