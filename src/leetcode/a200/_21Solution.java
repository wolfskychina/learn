package leetcode.a200;

public class _21Solution {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2){

        if(l1==null) return l2;
        if(l2==null) return l1;

        if(l1.val< l2.val){
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }

    // pass leetcode
    public ListNode mergeTwoListNonRecur(ListNode l1, ListNode l2){
        if(null == l1) return l2;
        if(null == l2) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(null!=l1 || null!=l2){
            if(null == l1){
                tail.next = l2;
                return dummy.next;
            }
            if(null == l2){
                tail.next = l1;
                return dummy.next;
            }

            if(l1.val < l2.val){
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            }else{
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }

        }

        return dummy.next;
    }
}
