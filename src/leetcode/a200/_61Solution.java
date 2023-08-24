package leetcode.a200;

public class _61Solution {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null) return head;

        int n=1;
        ListNode count = head;
        while(count.next!=null){
            n++;
            count = count.next;
        }

        if(k%n==0) return head;
        // 移动0位的时候，下面的解法不通用
        // pivot 和 count 都是最后一个元素 指向null

        n = n-k%n;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pivot = dummy;

        while(n!=0){
            pivot = pivot.next;
            n--;
        }

        ListNode temp = dummy.next;
        dummy.next = pivot.next;
        count.next = temp;
        pivot.next = null;

        return dummy.next;
    }
}
