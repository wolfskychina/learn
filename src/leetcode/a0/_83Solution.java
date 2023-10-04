package leetcode.a0;

import leetcode.util.ListNode;

/**
 * 删除链表中的冗余元素，只保留一份
 */
public class _83Solution {
   

     public ListNode deleteDuplicates(ListNode head) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode newEnd = dummy;
        
        if(head == null || head.next == null) return head;
        
        ListNode p = head.next;
        
        while(p!=null){
            
            if(newEnd.next.val == p.val){
             
                while(p!=null && newEnd.next.val == p.val){
                    p = p.next;
                }
            
                // 和上一题只有这里不一样
               newEnd.next.next =p;
                            newEnd=newEnd.next;

                
               if(p==null){
                     break;
               }else{
                     p = p.next;
               }
               
            }else{
                newEnd = newEnd.next;
                p = p.next;
            }
        }
        
        return dummy.next;
    }
    
}
