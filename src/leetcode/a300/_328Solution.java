package leetcode.a300;

import leetcode.util.ListNode;
/**
 * 将链表的偶数位的节点移动到链表的末尾
 */
public class _328Solution {

    /**
     * 链表分为奇偶长度，对终止条件需要区分
     * 但实际上处理逻辑是一样的
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;

        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        ListNode newTail = tail;
        ListNode current = head;

        while (current.next != tail && current.next.next != tail) {

            ListNode next = current.next.next;
            ListNode even = current.next;
            newTail.next = even;
            even.next = null;
            newTail = even;
            current.next = next;
            current = current.next;

        }

        // last node deal
        ListNode even = current.next;
        current.next = current.next.next;
        even.next = null;
        newTail.next = even;

        return head;

    }
}
