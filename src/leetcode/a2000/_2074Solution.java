package leetcode.a2000;

import leetcode.util.ListNode;

/**
 * 依次将链表中长度为偶数的分段内部反转顺序
 * {linkedlist}
 */
public class _2074Solution {

    public ListNode reverseEvenLengthGroups(ListNode head) {

        int n = 1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        while (p.next != null) {

            if (Math.min(n, len) % 2 == 0) {
                // 反转
                ListNode tail = p.next;
                if (tail == null)
                    break;
                for (int i = 1; i < n && tail.next != null; i++) {
                    ListNode tmp = tail.next;
                    tail.next = tmp.next;
                    tmp.next = p.next;
                    p.next = tmp;
                }
                p = tail;
            } else {
                // 不反转
                for (int i = 0; i < n && p.next != null; i++) {
                    p = p.next;
                }
            }
            len -= n;
            n++;
        }

        return dummy.next;
    }
}
