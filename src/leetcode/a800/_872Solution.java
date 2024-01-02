package leetcode.a800;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;
/**
 * 两颗二叉树的叶子结点是否相似
 */
public class _872Solution {
   
    /**
     * {inorder traverse}
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inordertraverse(root1,list1);
        inordertraverse(root2,list2);

        if(list1.size()!=list2.size())  return false;
        for(int i=0;i<list1.size();i++){
            if(list1.get(i)!=list2.get(i)){
                return false;
            }
        }
        return true;
        
    }

    private void inordertraverse(TreeNode root, List<Integer> list){
        if(root==null) return;

        if(root.left!=null) inordertraverse(root.left, list);

        if(root.left==null&&root.right==null){
            list.add(root.val);
        }

        if(root.right!=null) inordertraverse(root.right, list);

    }
}
