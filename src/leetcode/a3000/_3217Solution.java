package leetcode.a3000;

import leetcode.util.ListNode;

/**
 * 从链表中移除目标数组中出现过的所有数字
 * {linkedlist},{easy}
 */
public class _3217Solution {

    public ListNode modifiedList(int[] nums, ListNode head) {
        int[] count = new int[100001];
        for (int i : nums) {
            count[i]++;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            if (count[p.next.val] != 0)
                p.next = p.next.next;
            else
                p = p.next;
        }
        return dummy.next;
    }
}
