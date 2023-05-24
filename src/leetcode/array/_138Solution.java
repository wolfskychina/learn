package leetcode.array;

/**
 * 深度拷贝一个链表，链表中有一个随机指向的指针
 * 指向结构同样需要复制
 */
public class _138Solution {
   
    class RandomListNode {
        int val;
        RandomListNode next;
        RandomListNode random;
    
        public RandomListNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head, next;
        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;
            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;
            iter = next;
        }
    
        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
            iter.next.random = iter.random.next;
            }
        iter = iter.next.next;
        }
    
        // Third round: restore the original list, and extract the copy list.
        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;
        while (iter != null) {
            next = iter.next.next;
            // extract the copy
            copy = iter.next;
            copyIter.next = copy;//build the connection the previous node and the next node;
            copyIter = copy;
            // restore the original list
            iter.next = next;
        iter = next;
    }
    return pseudoHead.next;
    }
}
