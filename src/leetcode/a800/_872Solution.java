package leetcode.a800;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;
/**
 * 两颗二叉树的叶子结点是否相似
 * {binary tree}
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
            // java为了降低包装类生成的消耗，对于Integer会默认生成-128到127的所有对象，
            // 在这个范本范围内的都是引用这个默认范本对象，
            // 超过的则会新建，也就是范围内的是一个对象，范围外的两个对象，不能==的地址值比较。
            // TODO
            if(!list1.get(i).equals(list2.get(i))){
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

    public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<Integer>();
        if (root1 != null) {
            dfs(root1, seq1);
        }

        List<Integer> seq2 = new ArrayList<Integer>();
        if (root2 != null) {
            dfs(root2, seq2);
        }

        return seq1.equals(seq2);
    }

    public void dfs(TreeNode node, List<Integer> seq) {
        if (node.left == null && node.right == null) {
            seq.add(node.val);
        } else {
            if (node.left != null) {
                dfs(node.left, seq);
            }
            if (node.right != null) {
                dfs(node.right, seq);
            }
        }
    }
}
