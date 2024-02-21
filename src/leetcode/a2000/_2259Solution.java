package leetcode.a2000;
/**
 * 整数中删除某一位中的x，使得剩下的整数最大
 */
public class _2259Solution {

    /**
     * {greedy}
     * 删除遇到第一个后面位比digit大的
     * 为什么不能删后面满足条件的？
     * 因为同样的位数，删前面的，变大的位在左面，所以应该删前面的
     */
    public String removeDigit(String number, char digit) {

        int pre = -1;
        for (int i = 0; i < number.length(); i += 1) {
            if (number.charAt(i) == digit) {
                pre = i;
                if (i + 1 < number.length() && number.charAt(i + 1) > number.charAt(i)) // 只需要比较下一位就可，而非子串
                    break;
            }
        }
        return number.substring(0, pre) + number.substring(pre + 1);

    }
}
