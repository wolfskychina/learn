package leetcode.a2000;

import leetcode.util.ListNode;

/**
 * 统计链表中所有元素的出现频率
 * {easy}
 */
public class _3063Solution {
   
    public ListNode frequenciesOfElements(ListNode head) {

        int count[] = new int[100001];

        while(head!=null){
            count[head.val]++;
            head = head.next;
        }

        ListNode dummy = new ListNode();
        ListNode p = dummy;

        for(int i=1;i<count.length;i++){

            if(count[i]!=0){
                ListNode tmp = new ListNode(count[i]);
                p.next = tmp;
                p = tmp;
            }
        }

        return dummy.next;

    }
}
