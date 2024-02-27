package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并同类项
 * {easy}
 */
public class _2363Solution {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        int map[] = new int[1001];
        for (int[] item : items1) {

            map[item[0]] += item[1];
        }
        for (int[] item : items2) {

            map[item[0]] += item[1];
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {

            if (map[i] != 0) {
                // List<Integer> list = new ArrayList<>();
                // list.add(i);
                // list.add(map[i]);
                // List.of()速度更快
                res.add(List.of(i, map[i]));
            }
        }

        return res;
    }
}
