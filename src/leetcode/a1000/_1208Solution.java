package leetcode.a1000;

/**
 * 在maxCost限制下，能够使s变成t的最长的子串的长度
 * s到t的对应位置字符变化的代价为ascii码差的绝对值
 */
public class _1208Solution {

    /**
     * {two pointers}
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public int equalSubstring(String s, String t, int maxCost) {

        int l = 0;
        int r = 0;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int sum = 0;
        int res = 0;

        while (r < tt.length) {

            sum += Math.abs(ss[r] - tt[r]);
            r++;

            if (sum <= maxCost) {
                res = Math.max(res, r - l);
            } else {
                while (l < r && sum > maxCost) {
                    sum -= Math.abs(ss[l] - tt[l++]);
                }
            }
        }

        return res;
    }
}
