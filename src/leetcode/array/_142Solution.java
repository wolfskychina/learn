package leetcode.array;

/**
 * 判断一个链表是否有回路
 * 如果有，找到回路的起始点
 */
public class _142Solution {
   
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        
        ListNode p1 = head;
        ListNode p2 = head;
        if(p1==null||p1.next == null||p1.next.next ==null){
            return null;
        }
        
        ListNode p = null;
        while(p1.next!=null&&p2.next!=null&&p2.next.next!=null){
            
            p1 = p1.next;
            p2 = p2.next.next;
            
            if(p1==p2) {
                p =p1;
                break;}
            
        }
        
        if(p ==null) return null;
        
        int circleNum = 1;
        p1 = p.next;
        while(p!=p1){
            p1 = p1.next;
            circleNum ++;
        }
        
        p1 = head;
        p2 = head;
        for(int i=0;i<circleNum-1;i++){
            
            p2 = p2.next;
            
        }
        
        while(p2.next !=p1){
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return p2.next;
        
    }
}
