package leetcode.a500;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.util.TreeNode;

/**
 * 寻找bst中的众数，众数可能有多个
 * 进阶要求不使用额外的空间
 * {bst}
 */
public class _501Solution {

    List<Integer> list;
    int last = Integer.MIN_VALUE;
    int count = 0;
    int max = 0;

    /**
     * 使用额外存储空间的中根遍历方法
     * 
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        list = new LinkedList<>();

        inTraverse(root);

        int[] res = new int[list.size()];
        int i = 0;
        for (Integer j : list) {
            res[i++] = j;
        }
        return res;

    }

    private void inTraverse(TreeNode node) {
        if (node == null)
            return;
        inTraverse(node.left);

        if (node.val != last) {
            count = 1;
            last = node.val;

        } else {
            count++;
        }

        if (count > max) {
            max = count;
            // list = new LinkedList<>();
            // list的清除方法
            list.clear();
            list.add(node.val);

        } else if (count == max) {

            list.add(node.val);

        }

        inTraverse(node.right);
    }

    /**
     * 我们用 Morris 中序遍历的方法把中序遍历的空间复杂度优化到 O(1)。
     * 我们在中序遍历的时候，一定先遍历左子树，然后遍历当前节点，最后遍历右子树。
     * 在常规方法中，我们用递归回溯或者是栈来保证遍历完左子树可以再回到当前节点，
     * 但这需要我们付出额外的空间代价。我们需要用一种巧妙地方法可以在
     * O(1)的空间下，遍历完左子树可以再回到当前节点。
     * 我们希望当前的节点在遍历完当前点的前驱之后被遍历，我们可以考虑
     * 修改它的前驱节点的right指针。当前节点的前驱节点的right指针可能本来就指向当前节点（前驱是当前节点的父节点）
     * 当前节点没有左子树),也可能是当前节点左子树最右下的节点。
     * 如果是后者，我们希望遍历完这个前驱节点之后再回到当前节点，可以将它的right 指针指向当前节点。
     * 
     * Morris 中序遍历的一个重要步骤就是寻找当前节点的前驱节点，并且 Morris 中序遍历寻找下一个点始终是通过转移到
     * right 指针指向的位置来完成的。
     * 
     * 如果当前节点没有左子树，则遍历这个点，然后跳转到当前节点的右子树。
     * 如果当前节点有左子树，那么它的前驱节点一定在左子树上，我们可以在左子树上一直向右行走，找到当前点的前驱节点。
     * 如果前驱节点没有右子树，就将前驱节点的 right指针指向当前节点。
     * 这一步是为了在遍历完前驱节点后能找到前驱节点的后继，也就是当前节点。
     * 如果前驱节点的右子树为当前节点，说明前驱节点已经被遍历过并被修改了 right
     * 指针，这个时候我们重新将前驱的右孩子设置为空，遍历当前的点，然后跳转到当前节点的右子树。
     * 
     */
    int base, maxCount;
    List<Integer> answer = new ArrayList<Integer>();

    public int[] findMode1(TreeNode root) {
        TreeNode cur = root, pre = null;
        while (cur != null) {
            // 如果左子树为空，cur就是中序遍历下一个要访问的节点
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            // 寻找cur的前驱节点
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            // 递归找cur前驱的前驱
            // 直到左子树中第一个要被访问的节点
            // 每找到一个前驱，要更新该前驱的right指向后继节点
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

}
