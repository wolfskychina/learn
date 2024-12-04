package leetcode.a900;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0-1数组，每次可以将k个相邻元素反转
 * 最少多少次，能使全部的0变成1
 */
public class _995Solution {

    /**
     * {greedy},{queue}
     * 每个0都要翻转，所以可以从前向后遍历
     * 每个数字是否需要翻转，要看前面k-1个数字被翻转了多少次
     * 用队列记录当前元素之前的k-1个元素中被翻转的元素的坐标
     * 队列大小就是影响到当前元素的已经发生的翻转的次数
     * @param A
     * @param K
     * @return
     */
    public int minKBitFlips(int[] A, int K) {
        int res = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if (que.size() > 0 && i > que.peek() + K - 1) {
                que.poll();
            }
            // 1.本来是1，翻转奇数次变为0，所以需要再次翻转，放入队列
            // 2.本来是0，翻转偶数次还是0，所以需要再次翻转，放入队列
            if (que.size() % 2 == A[i]) {
                if (i + K > A.length)
                    return -1;
                que.offer(i);
                res += 1;
            }
        }
        return res;
    }
}
