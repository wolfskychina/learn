package leetcode.a1700;

import leetcode.util.ListNode;

/**
 * 交换链表中第k个节点和倒数第k个节点的值
 * k从1开始标号
 * {linkedlist}
 */
public class _1721Solution {

    public ListNode swapNodes(ListNode head, int k) {

        ListNode left = head;
        for(int i=1;i<k;i++){
            left = left.next;
        }
        ListNode p = left;
        ListNode right = head;
        
        // 很容易数错
        while(p.next!=null){
            p=p.next;
            right = right.next;
        }
        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
        return head;
    }
}
