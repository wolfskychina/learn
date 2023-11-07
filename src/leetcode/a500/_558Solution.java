package leetcode.a500;

import leetcode.util.quadTree.Node;
/**
 * 对两棵4-树的元素做逻辑或运算
 */
public class _558Solution {

    /**
     * {logical operation},{recursion}
     * 注意非叶子节点的两个节点对子节点进行或运算之后，需要判断四个子节点的运算结果
     * 如果四个子节点均为叶子结点且均为1或者0，那么这4个叶子节点需要聚合成一个新的叶子结点
     * @param q1
     * @param q2
     * @return
     */
    public Node intersect(Node q1, Node q2) {

        Node resTree;

        if (q1.isLeaf == true && q1.val == true) {
            resTree = q1;
            return resTree;
        }
        if (q1.isLeaf == true && q1.val == false) {
            resTree = q2;
            return resTree;
        }
        if (q2.isLeaf == true && q2.val == true) {
            resTree = q2;
            return resTree;
        }
        if (q2.isLeaf == true && q2.val == false) {
            resTree = q1;
            return resTree;
        }

        resTree = new Node();
        resTree.isLeaf = false;
        resTree.topLeft = intersect(q1.topLeft, q2.topLeft);
        resTree.topRight = intersect(q1.topRight, q2.topRight);
        resTree.bottomLeft = intersect(q1.bottomLeft, q2.bottomLeft);
        resTree.bottomRight = intersect(q1.bottomRight, q2.bottomRight);
        // 必须4个子节点都是叶子节点且值全部一致,才能归并
        if (resTree.topLeft.val == true && resTree.topRight.val == true &&
                resTree.bottomLeft.val == true && resTree.bottomRight.val == true && resTree.topLeft.isLeaf == true
                && resTree.topRight.isLeaf == true &&
                resTree.bottomLeft.isLeaf == true && resTree.bottomRight.isLeaf == true) {
            resTree.isLeaf = true;
            resTree.val = true;
            resTree.topLeft = null;
            resTree.topRight = null;
            resTree.bottomLeft = null;
            resTree.bottomRight = null;
        } else if (resTree.topLeft.val == false && resTree.topRight.val == false &&
                resTree.bottomLeft.val == false && resTree.bottomRight.val == false && resTree.topLeft.isLeaf == true
                && resTree.topRight.isLeaf == true && resTree.bottomLeft.isLeaf == true
                && resTree.bottomRight.isLeaf == true) {
            resTree.isLeaf = true;
            resTree.val = false;
            resTree.topLeft = null;
            resTree.topRight = null;
            resTree.bottomLeft = null;
            resTree.bottomRight = null;

        }

        return resTree;

    }
}
