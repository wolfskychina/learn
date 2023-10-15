package leetcode.a400;

import leetcode.util.flatternnode.Node;

public class _430Solution {
   
    public Node flatten(Node head) {

        if(head == null) return null;

        Node dummy = new Node();
        dummy.next = head;
        helper(head);
        return dummy.next;       
    }

    Node helper(Node head){

        while(head.next!=null){

            if(head.child!=null){
                Node last = helper(head.child);
                Node child = head.child;
                Node next = head.next;
                head.child =null;
                head.next = child;
                child.prev = head;
                last.next = next;
                next.prev = last;
                head = next;

            }else{
                head = head.next;
            }
        }

        // head.next == null;
         if(head.child!=null){
                Node last = helper(head.child);
                Node child = head.child;
                head.child =null;
                head.next = child;
                child.prev = head;
                last.next = null;
                return last;
            }

        return head;
    }
}
