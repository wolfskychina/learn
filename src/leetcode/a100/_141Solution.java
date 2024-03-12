package leetcode.a100;

import leetcode.util.ListNode;

/**
 * 判断一个链表是否有环
 * {linked list}
 */
public class _141Solution {
   
    public boolean hasCycle(ListNode head) {
        ListNode p1 =head;
        ListNode p2 =head;
        if(head ==null|| head.next  ==null ||head.next.next ==null){
            return false;
        }
        
        while(p1.next != null && p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2) return true;
        }
        
        return false;
    }
}
