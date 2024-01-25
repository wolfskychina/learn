package leetcode.a800;

import leetcode.util.ListNode;
/**
 * 链表每隔m个节点删除n个节点
 * {linkedlist}
 */
public class _1474Solution {

    public ListNode deleteNodes(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {

            for (int i = 0; i < m; i++) {
                if (p.next == null)
                    break;
                p = p.next;
            }
            if (p.next == null)
                break;
            ListNode pre = p;
            for (int i = 0; i < n; i++) {
                if (p.next == null) {
                    pre.next = null;
                    break;
                }
                p = p.next;
            }
            if (p.next == null) {
                pre.next = null;
                break;
            }
            pre.next = p.next;
        }
        return dummy.next;

    }
}
