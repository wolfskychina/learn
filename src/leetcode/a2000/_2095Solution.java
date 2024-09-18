package leetcode.a2000;

import leetcode.util.ListNode;

/**
 * 删除链表的中间节点
 * {linkedlist}
 */
public class _2095Solution {

    public ListNode deleteMiddle(ListNode head) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
