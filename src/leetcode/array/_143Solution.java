package leetcode.array;

/**
 * 将链表从中间对折，合并成一个新链表
 */
public class _143Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // count the total number of the list.
        int num = 0;
        ListNode p = head;
        while (p != null) {
            num++;
            p = p.next;
        }

        // find the head of the right half
        num = num - num / 2;
        p = head;
        while (num != 1) {
            p = p.next;
            num--;
        }

        ListNode head2 = p.next;
        // 前后两段先断开

        p.next = null;

        // reverse the second half
        ListNode dummy2 = new ListNode(-1);
        dummy2.next = head2;

        ListNode p1 = null;
        ListNode p2 = null;
        while (head2.next != null) {

            p2 = head2.next.next;
            p1 = dummy2.next;

            dummy2.next = head2.next;
            head2.next.next = p1;
            head2.next = p2;
        }

        // merget half1 and half2
        p1 = head;
        p2 = dummy2.next;

        ListNode p22 = null;

        while (p2 != null) {

            p22 = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = p22;
        }

        return;

    }
}
