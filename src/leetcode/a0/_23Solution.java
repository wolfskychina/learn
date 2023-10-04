package leetcode.a0;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.util.ListNode;

public class _23Solution {
   

    public ListNode mergeLists(List<ListNode> lists){

        if(null == lists || 0== lists.size()) return null;

        Queue<ListNode> queue = new PriorityQueue<>(lists.size(), (o1, o2) -> Integer.compare(o1.val, o2.val)
        );

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!queue.isEmpty()){

            tail.next = queue.poll();
            tail = tail.next;

            if(null!= tail.next){
                queue.offer(tail.next);
            }
        }

        return dummy.next;
    }
}
