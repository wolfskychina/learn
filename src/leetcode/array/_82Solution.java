package leetcode.array;

/**
 * 从已经排好序的链表中删掉冗余的元素
 * 只要有冗余元素，那么所有这个元素都删掉。
 */
public class _82Solution {
public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

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
}
