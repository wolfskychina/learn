package leetcode.a1700;

/**
 * 判断一个数字能否表示为不同的3的幂的和
 * {math}
 * 
 */
public class _1780Solution {

    /**
     * 转换成三进制表示，如果有的位不为1则说明有重复的幂
     * @param n
     * @return
     */
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
