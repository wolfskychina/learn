package leetcode.a1500;

import java.util.List;

import leetcode.util.narray.Node;

/**
 * 给出N叉树所有节点的列表，找到N叉树的根节点
 * 已知N叉树的所有节点的值不相同
 * {n-array tree}
 */
public class _1506Solution {

    /**
     * {math},{Pigeonhole Principle}抽屉原理
     * 将所有子节点累加，比所有节点值累加少的部分就是根节点
     * {TODO}
     * 
     * @param tree
     * @return
     */
    public Node findRoot(List<Node> tree) {
        Integer valueSum = 0;
        for (Node node : tree) {
            // 该值作为父节点添加
            valueSum += node.val;
            for (Node child : node.children)
                // 该值将作为子节点扣除
                valueSum -= child.val;
        }

        Node root = null;
        // 根节点的值是 valueSum
        for (Node node : tree) {
            if (node.val == valueSum) {
                root = node;
                break;
            }
        }
        return root;
    }

}
