package leetcode.array;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _23Solution {
    public class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeLists(List<ListNode> lists){

        if(null == lists || 0== lists.size()) return null;

        Queue<ListNode> queue = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        }
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
