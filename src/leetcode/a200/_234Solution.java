package leetcode.a200;

import leetcode.util.ListNode;

/**
 * 判断一个链表表示的字符串是不是回文串
 * {linked list},{palindrome}
 */
public class _234Solution {

    public boolean isPalindrome(ListNode head) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {

            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode dummy2 = new ListNode();
        ListNode newHead = null;
        ListNode next = null;

        // 将后半段链表反转
        while (p1 != null) {
            next = p1.next;
            newHead = dummy2.next;
            p1.next = newHead;
            dummy2.next = p1;
            p1 = next;
        }

        while (dummy2.next != null) {
            if (dummy.next.val != dummy2.next.val)
                return false;

            dummy = dummy.next;
            dummy2 = dummy2.next;

        }

        return true;

    }

    public static void main(String[] args) {
        _234Solution so = new _234Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        so.isPalindrome(node1);
    }

}
