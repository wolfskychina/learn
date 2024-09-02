package leetcode.a0;

import java.util.*;

/**
 * 一个数组的闭区间，重复的闭区间进行合并，返回合并后的闭区间
 */
public class _56Solution {

    public class Interval {

        public int start;
        public int end;

    }

    public List<Interval> merge(List<Interval> intervals) {

        /*
         * Collections.sort(intervals, new Comparator<Interval>() {
         * 
         * @Override
         * public int compare(Interval a, Interval b) {
         * return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
         * 
         * }
         * });
         */

        intervals.sort((a, b) -> a.start - b.start);

        LinkedList<Interval> merged = new LinkedList<>();
        // 排序之后一趟插入即可
        // 如果遍历到的片段的起点大于已经归并好的末节点的终点，说明是一个新的非重叠区间
        // 否则说明和之前归并好的节点的末节点的区间有重合，那么之前的末节点的终点有可能发生变化
        // 此时不需要插入新的区间，只需要修改末节点的终点即可
        for (Interval interval : intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int res[][] = new int[intervals.length][2];

        int i = 0;
        for (int j = 0; j < intervals.length; j++) {

            // 遍历到的区间需要和之前遍历过的上一个区间融合
            if (i == 0 || res[i - 1][1] < intervals[j][0]) {

                res[i++] = intervals[j];
            } else {
                res[i - 1][1] = Math.max(res[i - 1][1], intervals[j][1]);
            }
        }

        int ret[][] = new int[i][2];
        for (int k = 0; k < i - 1; k++) {
            ret[k] = res[k];
        }

        return ret;
    }

}
