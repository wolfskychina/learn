package leetcode.a800;

import leetcode.util.TreeNode;
/**
 * 在克隆树中寻找原树对应的节点
 * {easy}
 */
public class _1379Solution {
   
    private  TreeNode tar;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        found(original,cloned,target);
        return tar;
    }

    private  void found(TreeNode o, TreeNode c, TreeNode tar){

        if(o == tar){
            this.tar = c;
            return;
        }
        if(o==null) return;
        found(o.left,c.left,tar);
        found(o.right,c.right,tar);
    }
}
