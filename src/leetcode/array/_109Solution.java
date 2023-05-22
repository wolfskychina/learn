package leetcode.array;

import leetcode.array._21Solution.ListNode;
/**
 * 根据一个有序链表构建平衡bst
 */
public class _109Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private ListNode findMiddleElement(ListNode head) {


        // The pointer used to disconnect the left half from the mid node.
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
    
    
        // Iterate until fastPr doesn't reach the end of the linked list.
        while (fastPtr != null && fastPtr.next != null) {
          prevPtr = slowPtr;
          slowPtr = slowPtr.next;
          fastPtr = fastPtr.next.next;
        }
    
    
        // 这一段是把原来的两个list从中间断成两截
        // 相当于这个算法改了原来的list的指向
        if (prevPtr != null) {
          prevPtr.next = null;
        }
    
    
        return slowPtr;
      }
    
      /**
       * 找到root节点后将链表分成两段，然后递归
       * @param head
       * @return
       */
      public TreeNode sortedListToBST(ListNode head) {
    
    
        // If the head doesn't exist, then the linked list is empty
        if (head == null) {
          return null;
        }
    
    
        // Find the middle element for the list.
        ListNode mid = this.findMiddleElement(head);
    
    
        // The mid becomes the root of the BST.
        TreeNode node = new TreeNode(mid.val);
    
    
        // Base case when there is just one element in the linked list
        if (head == mid) {
          return node;
        }
    
    
        // Recursively form balanced BSTs using the left and right halves of the original list.
        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.next);
        return node;
      }
      
      
}
