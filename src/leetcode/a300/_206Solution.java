package leetcode.a300;

/**
 * 反转链表
 */
public class _206Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next ==null) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pnext = head.next;
        head.next =null;

        while(pnext !=null){

            ListNode ppnext =pnext.next;
            pnext.next = dummy.next;
            dummy.next = pnext;
            pnext = ppnext;

        }
        return dummy.next;

    }

}
