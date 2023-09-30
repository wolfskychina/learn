package leetcode.a300;

import leetcode.util.ListNode;

/**
 * 链表表示的整数加1
 * 链表是从高位向低位表示的
 */
public class _369Solution {

    /**
     * 只需要找到最右边的非9的位即可
     * @param head
     * @return
     */
    public ListNode plusOne(ListNode head) {

        // 设置为0，最高位进位也可以处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode p = dummy.next;
        while (p != null) {
            if (p.val != 9) {
                start = p;
            }
            p = p.next;
        }

        // start is the right most none 9 digit
        p = start;
        p.val = p.val + 1;

        while (p.next != null) {
            p.next.val = 0;
            p = p.next;
        }

        return start == dummy ? dummy : head;

    }
}
