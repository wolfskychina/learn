package leetcode.a700;

import java.util.ArrayList;
import java.util.List;

/**
 * 日程表添加记录，允许两个区间有重合但不允许三个区间有重合
 * 区间格式是左闭右开区间
 * {interval}
 */
public class _731Solution {

    /**
     * 额外增加一个两个区间重合的区间列表
     * 每次插入一个新的时刻，都需要更新这个区间
     */
    class MyCalendarTwo {
        List<int[]> booked;
        List<int[]> overlaps;

        public MyCalendarTwo() {
            booked = new ArrayList<int[]>();
            overlaps = new ArrayList<int[]>();
        }

        public boolean book(int start, int end) {
            for (int[] arr : overlaps) {
                int l = arr[0], r = arr[1];
                // 因为是左闭右开区间，所以不包含等号的情况
                // 等于的情况是非重合的，满足条件
                if (l < end && start < r) {
                    return false;
                }
            }
            for (int[] arr : booked) {
                int l = arr[0], r = arr[1];
                if (l < end && start < r) {
                    overlaps.add(new int[] { Math.max(l, start), Math.min(r, end) });
                }
            }
            booked.add(new int[] { start, end });
            return true;
        }
    }

}
