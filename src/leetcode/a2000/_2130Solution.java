package leetcode.a2000;

import leetcode.util.ListNode;

/**
 * 链表最大孪生和
 * 偶数个节点的链表，所有第i个和第(n-1-i)个节点对的值的和的最大值
 * {linked list},{two pointers}
 */
public class _2130Solution {

    public int pairSum(ListNode head) {
        ListNode prev = null, curr = head, last = head;
        /**
         * 快慢指针将列表对半分，同时对慢指针反转列表
         * 总的翻转次数是n/2-1次
         */
        while (last != null) {
            last = last.next.next;
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        int max = 0;
        while (curr != null) {
            max = Math.max(max, prev.val + curr.val);
            prev = prev.next;
            curr = curr.next;
        }
        return max;
    }
}
