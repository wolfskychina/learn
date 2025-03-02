package leetcode.a2000;

import leetcode.util.ListNode;

/**
 * 将链表表达的数翻倍
 * {linkedlist},{easy}
 */
public class _2816Solution {

    public ListNode doubleIt(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            // 注意三元运算符的优先级很低，如果不加括号会将前面的运算先算完
            p.val = p.val * 2 % 10 + (p.next.val > 4 ? 1 : 0);
            p = p.next;
        }
        p.val = p.val * 2 % 10;
        return dummy.val == 1 ? dummy : head;
    }

    public static void main(String[] args) {

        _2816Solution so = new _2816Solution();
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(8);
        ListNode p3 = new ListNode(9);
        p1.next = p2;
        p2.next = p3;
        so.doubleIt(p1);
    }
}
