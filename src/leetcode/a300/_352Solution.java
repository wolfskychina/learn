package leetcode.a300;

import java.util.Map;
import java.util.TreeMap;

/**
 * 352. Data Stream as Disjoint Intervals
 * 将数据流转换为不相连的数字区间
 * TODO
 */
public class _352Solution {

    /**
     * 巧妙的使用了Map.Entry来表示区间线段
     * 用TreeMap来实时进行线段的排序
     */
    class SummaryRanges {

        TreeMap<Integer, Integer> intervals;

        public SummaryRanges() {

            intervals = new TreeMap<Integer, Integer>();

        }

        public void addNum(int val) {

            Map.Entry<Integer, Integer> interval1 = intervals.ceilingEntry(val + 1);
            Map.Entry<Integer, Integer> interval0 = intervals.floorEntry(val);

            // 处理区间的边缘的情况
            if (interval0 != null && interval0.getKey() <= val && val <= interval0.getValue()) {
                // 完全被前一个区间包裹的情况
                return;
            } else {

                boolean leftAside = interval0 != null && interval0.getValue() + 1 == val;
                boolean rightAside = interval1 != null && interval1.getKey() - 1 == val;

                // val在两个区间中间，且可以将两个区间合并
                if (leftAside && rightAside) {

                    int left = interval0.getKey(), right = interval1.getValue();
                    intervals.remove(interval0.getKey());
                    intervals.remove(interval1.getKey());
                    intervals.put(left, right);

                } else if (leftAside) {
                    // val可以和左侧区间合并
                    intervals.put(interval0.getKey(), interval0.getValue() + 1);

                } else if (rightAside) {
                    // val可以和右侧区间合并，val成为新的左侧区间边界
                    int right = interval1.getValue();
                    intervals.remove(interval1.getKey());
                    intervals.put(val, right);

                } else {
                    // val跟相邻区间都不挨着，需要自己构成一个区间
                    intervals.put(val, val);

                }
            }
        }

        public int[][] getIntervals() {
            int size = intervals.size();
            int[][] ans = new int[size][2];
            int index = 0;
            for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
                ans[index][0] = entry.getKey();
                ans[index][1] = entry.getValue();
                index++;
            }

            return ans;
        }
    }
}
