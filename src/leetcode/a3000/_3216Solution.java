package leetcode.a3000;

/**
 * 交换同奇偶性的相邻字符后能够形成的最小数字字符串
 * {greedy},{easy}
 */
public class _3216Solution {

    public String getSmallestString(String s) {

        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length - 1; i++) {
            if ((ss[i] - '0') % 2 == (ss[i + 1] - '0') % 2 && (ss[i] > ss[i + 1])) {
                char tmp = ss[i];
                ss[i] = ss[i + 1];
                ss[i + 1] = tmp;
                break;
            }
        }
        return new String(ss);
    }
}
