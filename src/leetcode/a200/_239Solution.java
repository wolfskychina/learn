package leetcode.a200;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 输出滑动窗口滑动过程中每一时刻的最大值
 * {sliding window},{hard},{monotonic queue},{classic}
 * TODO
 */
public class _239Solution {

    /**
     * 单调栈不能滑动，题目要求的是滑动窗口，头部每一轮（可能）需要去掉
     * 可以用单调队列满足这种需求
     * 关键：用单调队列维持窗口内的实时最大值，并能保存未来的潜在最大值
     * 
     * @param a
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;

        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // 此时队列中的元素是单调递减的
            // 类似单调栈的操作，比新加入更小的就没必要保留了
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            // 这个时候队列中的元素一定又是单调递减的了

            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
}
