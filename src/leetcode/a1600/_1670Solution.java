package leetcode.a1600;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 前中后队列
 * {design},{queue}
 */
public class _1670Solution {
    FrontMiddleBackQueue q = new FrontMiddleBackQueue();

    /**
     * 使用两个双端队列，用左队列的队尾和右队列的队首模拟中间位置
     * 定义总大小为奇数时，中间节点为右队列的队首，即
     * 右队列节点数总是等于左队列节点数或者比左队列节点数多1
     */
    class FrontMiddleBackQueue {
        private final Deque<Integer> left = new ArrayDeque<>();
        private final Deque<Integer> right = new ArrayDeque<>();

        // 调整长度，保证 0 <= right.size() - left.size() <= 1
        // 从而保证可以在正中间插入删除元素
        private void balance() {
            if (left.size() > right.size()) {
                right.addFirst(left.pollLast());
            } else if (right.size() > left.size() + 1) {
                left.addLast(right.pollFirst());
            }
        }

        public void pushFront(int val) {
            left.addFirst(val);
            balance();
        }

        public void pushMiddle(int val) {
            if (left.size() < right.size()) {
                left.addLast(val);
            } else {
                right.addFirst(val);
            }
        }

        public void pushBack(int val) {
            right.addLast(val);
            balance();
        }

        public int popFront() {
            if (right.isEmpty()) { // 整个队列为空
                return -1;
            }
            int val = left.isEmpty() ? right.pollFirst() : left.pollFirst();
            balance();
            return val;
        }

        public int popMiddle() {
            if (right.isEmpty()) { // 整个队列为空
                return -1;
            }
            if (left.size() == right.size()) {
                return left.pollLast();
            }
            return right.pollFirst();
        }

        public int popBack() {
            if (right.isEmpty()) { // 整个队列为空
                return -1;
            }
            int val = right.pollLast();
            balance();
            return val;
        }
    }

    public static void main(String args[]) {
        _1670Solution so = new _1670Solution();
        so.q.pushFront(1);
        so.q.pushBack(2);
        so.q.pushMiddle(3);
        so.q.pushMiddle(4);
        so.q.popFront();
        so.q.popMiddle();
        so.q.popMiddle();
        so.q.popBack();
        so.q.popFront();

    }
}