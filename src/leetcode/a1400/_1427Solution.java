package leetcode.a1400;

/**
 * 字符串的左右移
 * {easy}
 */
public class _1427Solution {

    public String stringShift(String s, int[][] shift) {
        int count = 0;
        for (int[] move : shift) {

            if (move[0] == 0)
                count += move[1];
            else
                count -= move[1];
        }

        if (count == 0)
            return s;

        if (count > 0) {
            count = count % s.length();
            return s.substring(count) + s.substring(0, count);
        } else {
            count = -count;
            count = count % s.length();
            return s.substring(s.length() - count) + s.substring(0, s.length() - count);
        }
    }
}
