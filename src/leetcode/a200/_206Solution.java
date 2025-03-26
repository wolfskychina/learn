package leetcode.a200;

import leetcode.util.ListNode;

/**
 * 反转链表
 * {linked list}
 */
public class _206Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pnext = head.next;
        head.next = null;

        while (pnext != null) {

            ListNode ppnext = pnext.next;
            pnext.next = dummy.next;
            dummy.next = pnext;
            pnext = ppnext;

        }
        return dummy.next;

    }

    /**
     * 头插法可以不用提前移一位
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = null;

        ListNode cur = head;
        ListNode pnext;

        while (cur != null) {
            pnext = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = pnext;
        }
        return dummy.next;

    }

}
