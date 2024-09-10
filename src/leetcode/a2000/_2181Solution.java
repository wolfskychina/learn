package leetcode.a2000;

import leetcode.util.ListNode;

/**
 * 去掉链表中值为0的节点并将之间的节点进行压缩
 * {linkedlist}
 */
public class _2181Solution {

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        while (dummy.next != null && dummy.next.val == 0) {
            dummy = dummy.next;
        }
        if (dummy.next == null)
            return dummy.next;
        ListNode itr = dummy.next;
        while (itr != null) {

            int sum = 0;
            ListNode tmp = itr.next;
            while (tmp != null && tmp.val != 0) {
                sum += tmp.val;
                tmp = tmp.next;
            }
            itr.val += sum;
            while (tmp != null && tmp.val == 0) {
                tmp = tmp.next;
            }
            itr.next = tmp;
            itr = itr.next;
        }

        return dummy.next;
    }
}
