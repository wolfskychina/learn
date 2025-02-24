package leetcode.a800;

import leetcode.util.ListNode;

/**
 * nums中不存在的数能够把链表分成的段
 * {linkedlist},{easy}
 */
public class _817Solution {

    public int numComponents(ListNode head, int[] nums) {

        int[] count = new int[10001];
        for (int i : nums) {
            count[i]++;
        }
        int res = 0;
        while (head != null) {
            if (count[head.val] != 0)
                res++;
            while (head != null && count[head.val] != 0) {
                head = head.next;
            }
            while (head != null && count[head.val] == 0)
                head = head.next;

        }

        return res;
    }
}
