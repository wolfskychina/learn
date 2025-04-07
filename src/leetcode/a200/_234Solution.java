package leetcode.a200;

import leetcode.util.ListNode;

/**
 * 判断一个链表表示的字符串是不是回文串
 * {linked list},{palindrome}
 */
public class _234Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 链表反转用头插法改造了一下，更便于理解
        ListNode prev = new ListNode(-1);

        while (slow != null) {
            temp = slow.next;
            slow.next = prev.next;
            prev.next = slow;
            slow = temp;
        }

        fast = head;
        slow = prev.next;
        while (slow != null) {
            if (fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
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
