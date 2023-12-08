package leetcode.a0;

import leetcode.util.ListNode;
/**
 * 删除链表中的倒数第n个元素，要求只遍历一次链表
 */
public class _19Solution {

    /**
     * 注意i和p的起始位置
     * {linkedlist}
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode i = dummy;
        for (int j = 0; j < n; j++) {
            i = i.next;
        }
        ListNode p = dummy;
        while (i.next != null) {
            i = i.next;
            p = p.next;

        }

        p.next = p.next.next;

        return dummy.next;
    }
}
