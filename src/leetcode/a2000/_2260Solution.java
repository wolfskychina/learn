package leetcode.a2000;

import java.util.Arrays;

/**
 * 两个相等数字的最近距离
 * {easy}
 */
public class _2260Solution {

    public int minimumCardPickup(int[] cards) {
        int max = 0;
        // 优化所需的数组大小数量
        for (int i = 0; i < cards.length; i++) {
            max = Math.max(max, cards[i]);
        }
        int left[] = new int[max + 1];
        Arrays.fill(left, -1);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if (left[cards[i]] != -1) {
                res = Math.min(res, i - left[cards[i]] + 1);
            }
            left[cards[i]] = i;

        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
