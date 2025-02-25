package leetcode.a200;

import leetcode.util.ListNode;

/**
 * 删除链表中指定的节点，但是无法从表头遍历
 * {linked list}
 */
public class _237Solution {
   
    /**
     * 只能从目标节点开始逐个向前移动值
     * 需要保存指针的前一位指向
     */
    public void deleteNode1(ListNode node) {
        
        ListNode last = node;
        while(node.next!=null){
            node.val = node.next.val;
            last = node;
            node = node.next;
        }
        last.next =null;
    }
}
