package leetcode.a800;

import leetcode.util.ListNode;

/**
 * 返回链表的中间节点，如果总共有偶数个节点，返回后面的中间节点
 * {linkedlist}
 */
public class _876Solution {

    /**
     * {two pointers}
     * 
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;

        while (p2.next != null && p2.next.next != null) {

            p1 = p1.next;
            p2 = p2.next.next;

        }
        return p1.next;
    }

    /**
     * 链表求中间节点时，不使用dummy节点反而更加清晰
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head) {

        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {

            p1 = p1.next;
            p2 = p2.next.next;

        }
        return p1;
    }
}
