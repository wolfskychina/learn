package leetcode.a0;

public class _86Solution {
   
    public class ListNode {
        int val;
          ListNode next;
            ListNode(int x) { val = x; }
      }

    public ListNode partition(ListNode head, int x) {
        
        if(head == null || head.next ==null ) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode tail = dummy;
        ListNode pp = dummy;
        ListNode p = dummy.next;
        
        // 在开头先跳过连续的小于的值，避免tail.next == p这种情况

        while( p!=null && p.val<x){
                tail = tail.next;
                pp =pp.next;
                p = p.next;
        }
        
        while(p!=null){  
                        
            while( p!=null && p.val>=x){
                pp =pp.next;
                p = p.next;
            }
            
            if(p==null) break;
            
            ListNode l = tail.next;
            ListNode r = p.next;
            tail.next = p;
            p.next = l;
            p = r;
            pp.next=p;
            tail = tail.next;
                
        }
        
        return dummy.next;
    }
}
