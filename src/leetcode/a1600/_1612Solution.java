package leetcode.a1600;

import stuc.bst.Node;

/**
 * 检查两棵二叉表达树是否等价
 * {binary tree}
 */
public class _1612Solution {

    int count1[] = new int[26];
    int count2[] = new int[26];

    public boolean checkEquivalueence(Node<Character> root1, Node<Character> root2) {

        count(root1, count1);
        count(root2, count2);
        return equal(count1, count2);
    }

    private void count(Node<Character> p, int[] count) {
        // 注意表达式只有一个值的情况，需要特殊处理
        if (p.value != '+') {
            count[p.value - 'a']++;
            return;
        }
        if (p.left.value != '+') {
            count[p.left.value - 'a']++;
        } else {
            count(p.left, count);
        }
        if (p.right.value != '+') {
            count[p.right.value - 'a']++;
        } else {
            count(p.right, count);
        }
    }

    private boolean equal(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i])
                return false;
        }
        return true;
    }
}
