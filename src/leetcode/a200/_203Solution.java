package leetcode.a200;

import leetcode.util.ListNode;

/**
 * 删除链表中所有值为val的节点
 * {linked list},{easy}
 */
public class _203Solution {

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
