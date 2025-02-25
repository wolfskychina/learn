package leetcode.a0;

import leetcode.util.ListNode;

/**
 * 从已经排好序的链表中删掉冗余的元素
 * 只要有冗余元素，那么所有这个元素都删掉。
 * {linked list}
 */
public class _82Solution {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode newEnd = dummy;

        if (head == null || head.next == null)
            return head;

        ListNode p = head.next;

        while (p != null) {

            if (newEnd.next.val == p.val) {

                while (p != null && newEnd.next.val == p.val) {
                    p = p.next;
                }

                newEnd.next = p;

                if (p == null) {
                    break;
                } else {
                    p = p.next;
                }

            } else {
                newEnd = newEnd.next;
                p = p.next;
            }
        }

        return dummy.next;
    }

    /**
     * 5年重写优雅版
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;

        while (p.next != null && p.next.next != null) {

            if (p.next.val == p.next.next.val) {
                ListNode tmp = p.next;
                while (tmp != null && tmp.next != null && tmp.val == tmp.next.val) {
                    tmp = tmp.next;
                }
                // tmp is the node to be deleted
                p.next = tmp.next;
            } else {
                p = p.next;
            }

        }

        return dummy.next;

    }
}
