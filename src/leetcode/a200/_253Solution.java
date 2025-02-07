package leetcode.a200;

import java.util.Arrays;

/**
 * 给出一些会议时间安排，问最少需要多少间会议室
 * 最大并发问题
 * {greedy},{two pointers}
 */
public class _253Solution {
    /**
     * 为了求最少会议室，只需要知道某一时间段同时开会的会议的数量
     * 的最大可能值
     * 
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }
}
