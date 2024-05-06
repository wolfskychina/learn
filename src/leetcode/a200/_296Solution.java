package leetcode.a200;

import java.util.ArrayList;
import java.util.List;

/**
 * 求几个点的曼哈顿距离的最近中间点，使得这个点到几个点的曼哈顿
 * 距离和最小
 * {median}
 */
public class _296Solution {

    /**
     * 曼哈顿距离和最小其实就是几个点坐标的中位数的位置
     */
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();
        // 使得rowlist本身就是有序的
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rowList.add(i);
                }
            }
        }
        // 竖着遍历，使得collist在横坐标维度上是有序的
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    colList.add(i);
                }
            }
        }
        return getMin(rowList) + getMin(colList);
    }

    /**
     * 计算各个点偏离中位数的距离的和，不需要都和中位数相减
     * 而是最大的数减去最小的数，依次进行,这些差的和就是偏离中位数的距离
     *
     * @param list
     * @return
     */
    public int getMin(List<Integer> list) {
        if (list == null || list.size() == 0) return 0;
        int start = 0;
        int end = list.size() - 1;
        int result = 0;
        while (start < end) {
            result += list.get(end--) - list.get(start++);
        }
        return result;
    }
}
