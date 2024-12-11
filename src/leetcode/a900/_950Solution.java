package leetcode.a900;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按递增顺序显示卡牌
 * 每次拿一张卡之后，后面的一张卡会被洗到下面
 * 模拟
 * {queue}
 */
public class _950Solution {

    public int[] deckRevealedIncreasing(int[] deck) {

        int n = deck.length;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i);
        }
        int[] idx = new int[n];
        int j = 0;
        while (!q.isEmpty()) {
            idx[j++] = q.poll();
            if (!q.isEmpty()) {
                q.offer(q.poll());
            }
        }
        Arrays.sort(deck);
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[idx[i]] = deck[i];
        }

        return res;
    }
}
