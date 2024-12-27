package leetcode.a2000;

import leetcode.util.ListNode;

/**
 * 链表中插入最大公约数
 * {linkedlist},{gcd}
 */
public class _2807Solution {
   
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        if(head==null) return head;
        ListNode p = head;
        while(p.next!=null){
            int gcd = gcd(p.val,p.next.val);
            ListNode node = new ListNode(gcd);
            node.next = p.next;
            p.next =node;
            p = node.next;
        }

        return head;
    }

    private int gcd(int a,int b){

        while(a%b!=0){
            int tmp = a%b;
            a= b;
            b=tmp;
        }
        return b;
    }
}
