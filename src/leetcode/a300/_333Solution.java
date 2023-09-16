package leetcode.a300;

import leetcode.util.TreeNode;
/**
 * 求一个二叉树的节点最多的子bst
 * 原二叉树未必满足bst的性质
 */
public class _333Solution {
   
    int ans=0;

    public class Attr{
        int l;
        int r;
        int count;

        Attr(int l,int r,int count){
            this.l = l;
            this.r = r;
            this.count = count;
        }
    }
    /**
     * 递归返回的时候需要返回子树中值的区间和子树的节点数量 
     * 需要返回结构体
     * 想到了，没有敢写
     * @param root
     * @return
     */
    public int largestBSTSubtree(TreeNode root) {
        if (root==null) return 0;
        dfs(root);
        return ans;
    }

    Attr dfs(TreeNode root){
        if (root.left==null && root.right==null){
            ans=Math.max(ans,1);
            return new Attr(root.val,root.val,1);
        }
        int sz=1;
        boolean valid=true;
        int l=root.val,r=root.val;// 起初的范围是[root->val,root->val]，再根据左右子树更新范围
        if (root.left!=null){
            Attr L=dfs(root.left);
            if (L.count!=-1 && root.val>L.r){
                sz+=L.count;
                l=L.l;
            }
            else valid=false;
        }
        if (root.right!=null){
            Attr R=dfs(root.right);
            if (R.count!=-1 && root.val<R.l){
                sz+=R.count;
                r=R.r;
            }
            else valid=false;
        }
        if (valid){
            ans=Math.max(ans,sz);
            return new Attr(l,r,sz);
        }
        // 不是BST，sz设为-1标记不是BST，l,r多少都可以
        return new Attr(-1,-1,-1);
    }
}
