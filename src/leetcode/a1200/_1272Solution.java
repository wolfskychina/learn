package leetcode.a1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将一组区间片段中抠掉一段目标区间之后剩下的区间片段
 * {interval}
 */
public class _1272Solution {

    /**
     * 注意区间相对位置的三大类可能
     * @param intervals
     * @param toBeRemoved
     * @return
     */
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {

        List<List<Integer>> res = new ArrayList<>();

        int i = 0;
        while (i < intervals.length) {

            while (i < intervals.length && intervals[i][1] <= toBeRemoved[0]) {
                //List<Integer> list = new ArrayList<>();
                //list.add(intervals[i][0]);
                //list.add(intervals[i][1]);
                res.add(Arrays.asList(intervals[i][0],intervals[i][1]));
                i++;
            }

            while (i < intervals.length && intervals[i][0] < toBeRemoved[1]) {

                if (intervals[i][0] < toBeRemoved[0]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(intervals[i][0]);
                    list.add(toBeRemoved[0]);
                    res.add(list);
                }
                if (intervals[i][1] > toBeRemoved[1]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(toBeRemoved[1]);
                    list.add(intervals[i][1]);
                    res.add(list);
                }

                i++;
            }

            while (i < intervals.length && intervals[i][0] >= toBeRemoved[1]) {
                List<Integer> list = new ArrayList<>();
                list.add(intervals[i][0]);
                list.add(intervals[i][1]);
                res.add(list);
                i++;
            }

        }

        return res;
    }
}
