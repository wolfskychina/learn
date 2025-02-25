package leetcode.a1600;

import leetcode.util.ListNode;

/**
 * 合并两个列表
 * {linkedlist}
 */
public class _1669Solution {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = list1;
        ListNode p = dummy;
        ListNode h1 = dummy;
        ListNode h2 = dummy;
        for (int i = 0; i <= b; i++) {
            if (i == a) {
                h1 = p;
            }
            if (i == b) {
                h2 = p.next;
                break;
            }
            p = p.next;
        }
        h1.next = list2;
        tail2.next = h2.next;
        h2.next = null;

        return dummy.next;
    }
}
