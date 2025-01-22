package leetcode.a1500;

import java.util.Arrays;

/**
 * 可以获得的最大硬币数
 * 3的倍数堆的硬币
 * 每次挑选3堆，最多的给A，中间的给自己，剩下的给B
 * 问自己最多能拿到多少硬币
 * {math},{greedy}
 */
public class _1561Solution {

    /**
     * 因为A的一定是最多，只能让A拿最多自己拿其次，然后让B拿最少的
     * @param piles
     * @return
     */
    public int maxCoins(int[] piles) {

        Arrays.sort(piles);
        int sum = 0;
        for (int i = piles.length - 2, j = 0; j < piles.length / 3; i -= 2, j++) {
            sum += piles[i];
        }
        return sum;
    }
}
