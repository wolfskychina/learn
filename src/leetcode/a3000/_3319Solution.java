package leetcode.a3000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetcode.util.TreeNode;

/**
 * 第k大的完美子树
 * 完美子树是指满二叉树，按照节点数量进行排序
 * {binary tree}
 */
public class _3319Solution {


    private class Stuc{
        boolean ifPerfect;
        int num;

        public Stuc(boolean ifPerfect,int h){
            this.ifPerfect = ifPerfect;
            this.num = h;
        }
    }
    List<Integer> list;
    public int kthLargestPerfectSubtree1(TreeNode root, int k) {
        list = new ArrayList<>();
        dfs(root);
        Collections.sort(list);
        return list.size()>=k?list.get(list.size()-k):-1;
    }

    private Stuc dfs(TreeNode p){

        if(p==null) return new Stuc(false,0);
        if(p.left==null&&p.right==null){
            list.add(1);
            return new Stuc(true,1);
        }
        Stuc left = dfs(p.left);
        Stuc right = dfs(p.right);
        if(left.ifPerfect==true&&right.ifPerfect==true&&left.num == right.num){
            list.add(left.num*2+1);
            return new Stuc(true,left.num*2+1);
        }else{
            return new Stuc(false,-1);
        }
    }

    /**
     * 另外一种计数统计，不需要再排序
     * @param root
     * @param k
     * @return
     */
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        int[] cnt = new int[10];
        dfs(root, cnt);

        for (int i = cnt.length - 1; i >= 0; --i) {
            int c = cnt[i];

            if (c >= k) {
                return (1 << (i + 1)) - 1;
            }

            k -= c;
        }

        return -1;
    }

    /**
     * 用负数表示返回非满二叉树
     * @param node
     * @param cnt
     * @return
     */
    public int dfs(TreeNode node, int[] cnt) {
        if (node == null) {
            return -1;
        }

        int leftH = dfs(node.left, cnt);
        int rightH = dfs(node.right, cnt);

        if (leftH == -2 || leftH != rightH) {
            return -2;
        }

        ++cnt[leftH + 1];

        return leftH + 1;
    }
}
