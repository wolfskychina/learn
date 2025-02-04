package leetcode.a3000;

/**
 * 二进制字符串，1能够移到0的右侧
 * 问最多能执行的这种操作可以有多少？
 * {greedy}
 */
public class _3228Solution {

    /**
     * 统计左侧的1的总数，每遇到一组连续的0，
     * 当前累计的1都可以往右移动
     * @param s
     * @return
     */
    public int maxOperations(String s) {

        char[] ss = s.toCharArray();
        int sum = 0;
        int num1 = 0;
        int i = 0;
        while (i < ss.length) {

            while (i < ss.length && ss[i] == '1') {
                num1++;
                i++;
            }
            if (i == ss.length)
                break;
            while (i < ss.length && ss[i] == '0')
                i++;
            sum += num1;
        }
        return sum;
    }
}
