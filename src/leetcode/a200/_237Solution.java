package leetcode.a200;

import leetcode.util.ListNode;

/**
 * 删除链表中指定的节点，但是无法从表头遍历
 */
public class _237Solution {
   
    /**
     * 只能从目标节点开始逐个向前移动值
     * 需要保存指针的前一位指向
     * TODO 想一次性写对也不容易
     */
    public void deleteNode(ListNode node) {

        ListNode pre  = new ListNode();
        while(node !=null ){
            if(node.next!=null){
                node.val = node.next.val;
                pre = node;
            }
                
            node = node.next;
        }
        pre.next = null;

    }
}
