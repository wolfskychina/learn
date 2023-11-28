package leetcode.a700;

import leetcode.util.ListNode;
/**
 * 将链表拆成k组，要求所有的组的长度之差不超过1，并且长度长的片段在前面
 */
public class _725Solution {

    /**
     * {linked list}
     * @param head
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode p = head;
        int num = 0;
        while (p != null) {
            num++;
            p = p.next;
        }
        int innerlength = num / k;
        int longertimes = num % k;
        ListNode[] res = new ListNode[k];
        ListNode nextHead = head;
        for (int i = 0; i < k; i++) {
            if (i < longertimes) {
                // 每innerlength+1个截断
                nextHead = cutlist(nextHead, innerlength + 1, res,i);
            } else {
                // 每innerlength个截断
                nextHead = cutlist(nextHead, innerlength, res,i);
            }

        }
        return res;

    }

    private ListNode cutlist(ListNode nextHead, int innerlength, ListNode[] res,int i) {
        res[i] = nextHead;
        if(nextHead ==null) return null;

        int k=0;
        while(k<innerlength-1){
            nextHead = nextHead.next;
            k++;
        }
        ListNode next = nextHead.next;
        nextHead.next =null;

        return next;
    }
}
