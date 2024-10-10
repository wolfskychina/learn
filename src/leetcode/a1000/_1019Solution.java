package leetcode.a1000;

import java.util.ArrayDeque;
import java.util.Deque;

import leetcode.util.ListNode;

/**
 * 链表中下一个值更大的节点
 */
public class _1019Solution {

    /**
     * 单调栈
     * {monotonic stack}
     * 
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {

        int num = 0;
        ListNode p = head;
        while (p != null) {

            num++;
            p = p.next;
        }
        int[] res = new int[num];
        if (head == null)
            return res;
        Deque<Node> s = new ArrayDeque<>();
        int idx = 0;
        s.offerLast(new Node(idx++, head));
        head = head.next;
        while (head != null) {

            while (!s.isEmpty() && s.peekLast().p.val < head.val) {

                Node node = s.pollLast();
                res[node.idx] = head.val;

            }
            s.offerLast(new Node(idx++, head));

            head = head.next;
        }

        return res;

    }

    class Node {
        int idx;
        ListNode p;

        public Node(int idx, ListNode p) {
            this.idx = idx;
            this.p = p;
        }
    }
}
