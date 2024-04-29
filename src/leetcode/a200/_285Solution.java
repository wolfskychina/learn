package leetcode.a200;

import leetcode.util.TreeNode;

/**
 * 求一个BST树中某个节点中序遍历的后继节点
 * {bst}
 */
public class _285Solution {

    public TreeNode findNext(TreeNode root, TreeNode p){

        if(p.right!=null){
            p = p.right;
            while(p.left!=null){
                p = p.left;
            }
            return p;
        }

        // 需要向上判断
        // 注意p有可能是最大的节点，没有后继节点
        TreeNode pre = null;
        while(root.val!=p.val){
            if(root.val > p.val){
                pre = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return pre;

    }
}
