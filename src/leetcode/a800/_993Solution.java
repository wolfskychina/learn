package leetcode.a800;

import leetcode.util.TreeNode;
/**
 * 寻找二叉树的堂兄弟节点是否存在
 * {binary tree}
 */
public class _993Solution {
   
    public boolean isCousins(TreeNode root, int x, int y) {

        TreeNode dummy = new TreeNode();
        dummy.left = root;

        int resx[] = new int[2];
         findParent(dummy,x,0,resx);
        int resy[] = new int[2];
        findParent(dummy,y,0,resy);
        if(resx[0]!=resy[0]&&resx[1]==resy[1])
            return true;
        else    
            return false;
    }

    private void findParent(TreeNode p, int val,int dept, int[] res){
        
        if(p.left!=null){
            if(p.left.val == val){
                res[0]= p.val;
                res[1]=dept;
                return;
            }
            findParent(p.left,val,dept+1,res);
        }

        if(p.right!=null){
            if(p.right.val == val){
                res[0] =p.val;
                res[1] = dept;
                return;
            }
            findParent(p.right,val,dept+1,res);
        }

        return ;
        
    }
}
