package leetcode.a400;

import leetcode.util.ListNode;
/**
 * 链表加法，头结点是最高位
 */
public class _445Solution {

    /**
     * 递归处理，区分l1只加进位还是l1，l2加进位两种情况进行递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 需要两种递归
        // 前面部分递归加1
        // 后面部分递归加另外一条链表中的节点
        // 两种递归可以统一
        int len1 = 0;
        int len2 = 0;
        ListNode dummy = new ListNode();
        dummy.next = l1;
        while (dummy.next != null) {
            len1++;
            dummy = dummy.next;
        }
        ListNode dummy2 = new ListNode();
        dummy2.next = l2;
        while (dummy2.next != null) {
            len2++;
            dummy2 = dummy2.next;
        }
        // TODO dummy =l1 和dummy.next =l1的区别
        // dummy =l1 只是改了本身指针的指向
        // dummy.next =l1 不仅改了next的指针指向
        // 更是改了dummy对象的属性
        // 因此不能轻易的更改dummy.next的指向
        // 为了保险起见，最好new一个新的指针作为临时变量
        if (len1 < len2) {
            int tmplen = len1;
            len1 = len2;
            len2 = tmplen;
            dummy = l1;
            l1 = l2;
            l2 = dummy;
        }
        int steps = len1 - len2;
        ListNode d1 = new ListNode();
        d1.next = l1;
        ListNode d2 = new ListNode();
        d2.next = l2;

        int carry = helper(steps, d1.next, d2.next);

        // 处理最高位产生的进位
        if (carry == 0) {
            return l1;
        } else {
            ListNode node = new ListNode();
            node.val = 1;
            node.next = l1;
            return node;

        }

    }

    private int helper(int steps, ListNode next, ListNode next2) {

        if (next == null)
            return 0;

        if (steps != 0) {

            next.val += helper(steps - 1, next.next, next2);
        } else {

            next.val += next2.val + helper(0, next.next, next2.next);
        }

        if (next.val > 9) {
            next.val %= 10;
            return 1;
        } else {
            return 0;
        }

    }
}
