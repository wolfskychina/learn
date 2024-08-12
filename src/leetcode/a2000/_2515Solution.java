package leetcode.a2000;

/**
 * 到目标字符串的最短距离
 * {easy}
 */
public class _2515Solution {

    public int closetTarget(String[] w, String t, int s) {
        int n = w.length;
        for (int step = 0, l = s, r = s; step < n; l = (--l + n) % n, r = ++r % n, step++)
            if (w[l].equals(t) || w[r].equals(t))
                return step;
        return -1;
    }
}
