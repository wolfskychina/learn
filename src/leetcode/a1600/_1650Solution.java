package leetcode.a1600;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.Node;

/**
 * 一个节点有指向父节点的引用的二叉树
 * 寻找两个节点的最小公共子节点
 * {binary tree},{lca}
 * 
 * @param p
 * @param q
 * @return
 */
public class _1650Solution {

    List<Node> list1;
    List<Node> list2;

    /**
     * 比较笨的办法，将p和q到根节点的路径分别记录下来
     * 然后倒序找最下面的公共节点
     * 
     * @param p
     * @param q
     * @return
     */
    public Node lowestCommonAncestor(Node p, Node q) {

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        while (p != null) {
            list1.add(p);
            p = p.parent;
        }
        while (q != null) {
            list2.add(q);
            q = q.parent;
        }
        int idx1 = list1.size() - 1;
        int idx2 = list2.size() - 1;
        while (idx1 >= 0 && idx2 >= 0 && list1.get(idx1) == list2.get(idx2)) {
            idx1--;
            idx2--;
        }

        return list1.get(idx1 + 1);
    }

    /**
     * 巧妙的通过迭代的方式
     * @param p
     * @param q
     * @return
     */
    public Node lowestCommonAncestor1(Node p, Node q) {
        Node a = p;
        Node b = q;

        // 第一遍跑完后，获取了两边的差值
        // 交换位置再重跑，交叉的时候就是对齐的位置
        while (a != b) {
            if (a == null) {
                a = q;
            } else {
                a = a.parent;
            }

            if (b == null) {
                b = p;
            } else {
                b = b.parent;
            }
        }
        return a;
    }
}
