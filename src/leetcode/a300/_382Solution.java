package leetcode.a300;

import leetcode.util.ListNode;

public class _382Solution {
   
    ListNode cur ;
    int length =1;
    public _382Solution(ListNode head) {
        cur=head;
        ListNode p =head;
        while(p.next!=null){
            p=p.next;
            length++;
        }

        p.next = head;

    }
    
    public int getRandom() {

        int step = (int)(Math.random()*length);
        while(step!=0){
            cur=cur.next;
            step--;
        }

        return cur.val;


    }
}
