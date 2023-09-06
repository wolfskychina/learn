package leetcode.a200;

/**
 * 删除链表中所有值为val的节点
 */
public class _203Solution {

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode();

        dummy.next = head;

        head = dummy;

        while(head.next !=null ){

            if(head.next.val != val) {
                head = head.next;
                continue;
            }

            head.next = head.next.next;
        }


        return dummy.next;

    }

}
