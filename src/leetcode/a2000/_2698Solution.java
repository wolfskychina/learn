package leetcode.a2000;

/**
 * 一个整数的惩罚数
 * {backtrace}
 */
public class _2698Solution {

    public int punishmentNumber(int n) {

        int res = 0;
        for (int i = 1; i <= n; i++) {

            int tar = i;
            String s = String.valueOf(i * i);
            if (backtrace(0, s, tar, 0)) {
                res += i * i;
            }
        }
        return res;
    }

    private boolean backtrace(int start, String s, int tar, int curSum) {

        if (start == s.length()) {
            if (curSum == tar) {
                return true;
            } else {
                return false;
            }
        }
        if (curSum > tar)
            return false;
        boolean found = false;
        for (int i = start + 1; i <= s.length(); i++) {
            int tmp = Integer.parseInt(s.substring(start, i));
            found |= backtrace(i, s, tar, curSum + tmp);
            if (found)
                return true;
        }
        return false;
    }

}
