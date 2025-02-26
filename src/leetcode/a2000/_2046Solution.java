package leetcode.a2000;

import leetcode.util.ListNode;

/**
 * 给已经按照绝对值排序的链表重新按照大小排序
 * {linkedlist}
 */
public class _2046Solution {

    public ListNode sortLinkedList(ListNode head) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        // TODO 头插法需要提前往后移动一位，保证待插入的不是当前队尾的元素
        // 否则会死循环
        ListNode p = dummy.next;
        while (p.next != null) {

            if (p.next.val < 0) {
                ListNode tmp = p.next;
                p.next = p.next.next;
                tmp.next = dummy.next;
                dummy.next = tmp;

            } else
                p = p.next;
        }
        return dummy.next;
    }
}
