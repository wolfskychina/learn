package leetcode.array;

import leetcode.util.TreeNode;
/**
 * 统计一棵树中有多少棵由完全相同元素组成的子树
 */
public class _250Solution {
   
    int total = 0;
    /**
     * 一开始弄混了返回子树为空和子树不为相同元素子树的情况
     * 实际上是两种不同的状态
     * 如果子树为空，那么他的父节点有可能组成unisub
     * 如果子树不是相同元素子树，那么他的父节点必然不是unisubtree
     * 所以两种情况需要不同的返回值作为区分
     * @param root
     * @return
     */
    public int countUnivalSubtrees(TreeNode root) {

        dealNode(root);
        return total;
        
    }

    private int dealNode(TreeNode node){

        if(node == null) return -1999;
        if(node.left == null && node.right == null){
            total++;
            return node.val;
        }
        // now the node.left and node.right can't be null at the same time.
        int l = dealNode(node.left);
        int r = dealNode(node.right);
        if( l == -1999 && node.val == r
            || r == -1999 && node.val ==l
            || r==l && node.val == r)
            {
                total++;
                return node.val;
            }else{
                return -1998;
            }
    }
}
