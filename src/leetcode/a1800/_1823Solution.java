package leetcode.a1800;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 找出游戏的获胜者
 * 每轮都淘汰掉第k个报数的人，问最后剩下人的编号
 * {math}
 */
public class _1823Solution {

    /**
     * 使用队列进行模拟
     * @param n
     * @param k
     * @return
     */
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }

    /**
     * 约瑟夫环问题
     * @param n
     * @param k
     * @return
     */
    public int findTheWinner1(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (k + findTheWinner(n - 1, k) - 1) % n + 1;
    }

}
