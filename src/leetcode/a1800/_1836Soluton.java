package leetcode.a1800;

import leetcode.util.ListNode;

/**
 * 删除未排序链表中所有的重复元素
 * {linkedlist},{counting}
 */
public class _1836Soluton {

    public ListNode deleteDuplicatesUnsorted(ListNode head) {

        int[] count = new int[100001];
        ListNode p = head;
        while (p != null) {

            count[p.val]++;
            p = p.next;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tail = dummy;
        p = head;
        while (p != null) {

            if (count[p.val] == 0) {
                tail.next = p;
                tail = tail.next;
            }
            p = p.next;
        }

        // TODO 收尾需要将tail的next置为null
        tail.next = null;

        return dummy.next;
    }
}
