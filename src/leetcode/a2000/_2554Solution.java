package leetcode.a2000;

/**
 * 从一个范围内选取最多的整数
 * {greedy},{easy}
 */
public class _2554Solution {

    public int maxCount(int[] banned, int n, int maxSum) {

        int[] set = new int[10001];

        for (int b : banned) {
            set[b] = 1;
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (set[i] == 1)
                continue;
            if (maxSum - i >= 0) {
                maxSum -= i;
                res++;
            } else {
                break;
            }
        }

        return res;
    }
}
