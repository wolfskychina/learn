package leetcode.a900;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间列表的交集
 * {two pointers},{greedy}
 */
public class _986Solution {

    private List<int[]> list = new ArrayList<>();

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {

            if (compare(i, j, firstList, secondList) == 1) {
                i++;
            } else {
                j++;
            }
        }
        int[][] res = new int[list.size()][2];
        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(k);
        }
        return res;
    }

    private int compare(int i, int j, int[][] list1, int[][] list2) {

        int x1 = list1[i][0];
        int y1 = list1[i][1];
        int x2 = list2[j][0];
        int y2 = list2[j][1];

        int xx = Math.max(x1, x2);
        int yy = Math.min(y1, y2);
        if (xx <= yy)
            list.add(new int[] { xx, yy });

        // 注意是右端小的区间往后移动一个
        if (y1 < y2)
            return 1;
        else
            return 2;
    }

    public static void main(String[] args) {
        _986Solution so = new _986Solution();
        int[][] list1 = { { 0, 2 }, { 5, 10 } };
        int[][] list2 = { { 1, 5 }, { 8, 12 } };
        so.intervalIntersection(list1, list2);
    }
}
