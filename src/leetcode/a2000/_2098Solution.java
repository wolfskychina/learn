package leetcode.a2000;

import java.util.Arrays;

/**
 * 同lcp40
 * 从数组中挑选cnt个数字，能够获得的最大的偶数和是多少
 * 如果不存在偶数和，返回0
 * {greedy}
 */
public class _2098Solution {

    public long largestEvenSum(int[] cards, int cnt) {
        Arrays.sort(cards);
        int len = cards.length;
        if (len < cnt) {
            return 0;
        }
        long sum = 0;
        int minOdd = 100001, minEven = 100001;
        for (int i = len - 1; i >= len - cnt; i--) {
            int cur = cards[i];
            if ((cur & 1) == 1) {
                minOdd = Math.min(minOdd, cur);
            } else {
                minEven = Math.min(minEven, cur);
            }
            sum += cur;
        }
        if ((sum & 1) == 0) {
            return sum;
        } else {
            int maxOdd = -1, maxEven = -1;
            for (int i = len - cnt - 1; i >= 0; i--) {
                int cur = cards[i];
                if ((cur & 1) == 1) {
                    maxOdd = Math.max(maxOdd, cur);
                } else {
                    maxEven = Math.max(maxEven, cur);
                }
            }
            long ans1 = maxEven == -1 ? -1 : minOdd == 1001 ? -1 : sum - minOdd + maxEven;
            long ans2 = maxOdd == -1 ? -1 : minEven == 1001 ? -1 : sum - minEven + maxOdd;
            return Math.max(ans1, ans2);
        }
    }
}
