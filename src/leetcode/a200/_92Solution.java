package leetcode.a200;

/**
 * 将链表中第m和n之间的节点进行反转
 */
public class _92Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode h = dummy;
        ListNode t;

        for (int i = 1; i < m; i++) {
            h = h.next;
        }

        t = h.next;

        ListNode next;
        ListNode hnext = h.next;

        for (int i = 0; i < n - m; i++) {

            hnext = h.next;
            next = t.next.next;
            h.next = t.next;
            t.next.next = hnext;
            t.next = next;

        }

        return dummy.next;
    }
}
