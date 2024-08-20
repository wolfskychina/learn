package leetcode.lcp;

import java.util.Arrays;

/**
 * 从数组中挑选cnt个数字，能够获得的最大的偶数和是多少
 * 如果不存在偶数和，返回0
 * {greedy}
 */
public class Lcp40 {

	/**
	 * 先排序，找出前cnt个，如果符合条件就直接返回
	 * 如果不符合条件，就从剩下的数字中挑选最大的奇数和偶数
	 * 分两次替换原来的最小的偶数和奇数，更改原总数和的奇偶性
	 * 如果不存在剩下最大的奇数和偶数，返回0
	 * 
	 * @param cards
	 * @param cnt
	 * @return
	 */
	public int maxmiumScore(int[] cards, int cnt) {
		Arrays.sort(cards);
		int len = cards.length;
		if (len < cnt) {
			return 0;
		}
		int sum = 0;
		int minOdd = 1001, minEven = 1001;
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
			int ans1 = maxEven == -1 ? 0 : minOdd == 1001 ? 0 : sum - minOdd + maxEven;
			int ans2 = maxOdd == -1 ? 0 : minEven == 1001 ? 0 : sum - minEven + maxOdd;
			return Math.max(ans1, ans2);
		}
	}
}
