package leetcode.a800;

/**
 * 字符串中连续相同字符的数量
 * {easy}
 */
public class _1446Solution {

    public int maxPower(String s) {

        char cur = ' ';
        int max = 0;
        int tmp = 1;
        for (char c : s.toCharArray()) {
            if (c == cur) {
                tmp++;
            } else {
                max = Math.max(tmp, max);
                tmp = 1;
                cur = c;
            }
        }
        return Math.max(max, tmp);
    }
}
