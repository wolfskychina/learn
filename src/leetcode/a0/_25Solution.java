package leetcode.a0;

import leetcode.util.ListNode;

public class _25Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        // 统计节点总的数量
        for (ListNode i = head; i != null; n++, i = i.next)
            ;

        ListNode dmy = new ListNode(0);
        dmy.next = head;
        for (ListNode prev = dmy, tail = head; n >= k; n -= k) {
            // 插入k-1个元素

            for (int i = 1; i < k; i++) {
                // tail.next.next 是要保存的下一个要插到头部的节点
                // tail.next 是当前要被插入到头部的节点
                // k个元素中的第一个可以不用插入
                ListNode next = tail.next.next;
                tail.next.next = prev.next;
                prev.next = tail.next;
                tail.next = next;
                // 一个指针一旦原来位置被使用了，就可以马上更改他的指向了
                // prev的地址在每次循环中都不变，有点类似于每次将后面的一个指针插到最前面
                // 类似于一个使用指针的插入排序
            }

            prev = tail;
            tail = tail.next;
        }
        return dmy.next;
    }
}
