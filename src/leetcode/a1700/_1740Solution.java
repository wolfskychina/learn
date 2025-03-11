package leetcode.a1700;

import leetcode.util.TreeNode;

/**
 * 二叉树中两个节点的最近距离
 * {binary tree}
 */
public class _1740Solution {

    int res = 0;

    public int findDistance(TreeNode root, int p, int q) {

        if (p == q)
            return 0;
        find(root, p, q);

        return res;

    }

    private int find(TreeNode node, int p, int q) {

        if (res != 0)
            return -1;
        
        int l = find(node.left, p, q);
        int r = find(node.right, p, q);

        if ((node.val == p || node.val == q) && (l>=0 || r>=0)){
            res = 1+ (l>=0?l:r);
            return -1;
        }else if(node.val == p || node.val == q){
            return 0;
        }
        
        if(l>=0&&r>=0){
            res = l+r+2;
            return -1;
        }else if(l>=0){
            return l+1;
        }else{
            return r+1;
        }

    }
}
