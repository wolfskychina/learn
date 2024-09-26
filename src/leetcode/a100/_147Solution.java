package leetcode.a100;

import leetcode.util.ListNode;

/**
 * 基于链表的插入排序
 * {linked list},{sorting}
 */
public class _147Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode helper = new ListNode(0); // new starter of the sorted list
        ListNode cur = head; // the node will be inserted
        ListNode pre = helper; // insert node between pre and pre.next
        ListNode next = null; // the next node will be inserted
        // not the end of input list
        while (cur != null) {
            next = cur.next;
            // find the right place to insert
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            // insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }

    /**
     * 用归并的思想对链表进行排序
     * 
     * @param head
     * @return
     */
    public ListNode insertionSortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = head;
        ListNode left = slow.next;
        // 归并前将链表的前后两部分断开
        slow.next = null;
        ListNode sortLeft = insertionSortList(left);
        ListNode sortRight = insertionSortList(right);
        ListNode sortedList = new ListNode(0), res = sortedList;
        while (sortRight != null && sortLeft != null) {
            if (sortLeft.val < sortRight.val) {
                sortedList.next = sortLeft;
                sortLeft = sortLeft.next;
            } else {
                sortedList.next = sortRight;
                sortRight = sortRight.next;
            }
            sortedList = sortedList.next;
        }
        sortedList.next = sortLeft == null ? sortRight : sortLeft;
        return res.next;
    }
}
