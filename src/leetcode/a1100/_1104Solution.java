package leetcode.a1100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * zigzag二叉树寻路
 * {binary tree},{math}
 */
public class _1104Solution {

    /**
     * 根据每层的节点数翻倍来找到label所在的层
     * 然后根据层数的奇偶性来获得正确的节点
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree(int label) {
        int row = 1, rowStart = 1;
        while (rowStart * 2 <= label) {
            row++;
            rowStart *= 2;
        }
        if (row % 2 == 0) {
            label = getReverse(label, row);
        }
        List<Integer> path = new ArrayList<Integer>();
        while (row > 0) {
            if (row % 2 == 0) {
                path.add(getReverse(label, row));
            } else {
                path.add(label);
            }
            row--;
            label >>= 1;
        }
        Collections.reverse(path);
        return path;
    }

    public int getReverse(int label, int row) {
        return (1 << row - 1) + (1 << row) - 1 - label;
    }
}
