package leetcode.a1000;

import leetcode.util.ListNode;

/**
 * 链表表示的二进制转成整数
 * {bit manuplation}
 */
public class _1290Solution {

    public int getDecimalValue(ListNode head) {

        int res = 0;
        while (head != null) {
            // TODO 位运算符号的优先级很低
            res = (res << 1) + head.val;
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {

        _1290Solution so = new _1290Solution();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        so.getDecimalValue(head);
    }
}
