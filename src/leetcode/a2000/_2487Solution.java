package leetcode.a2000;

import leetcode.util.ListNode;

/**
 * 删除所有在右侧存在更大值的节点
 * {linkedlist} 
 */
public class _2487Solution {

    /**
     * 递归方式
     * @param head
     * @return
     */
    public ListNode removeNodes(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode node = removeNodes(head.next); // 返回的链表头一定是最大的
        // 当前元素只有保留或者不保留两种方式
        if (node.val > head.val) {
            return node; // 删除 head
        }
        head.next = node; // 不删除 head
        return head;
    }

}
