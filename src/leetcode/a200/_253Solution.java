package leetcode.a200;

import java.util.Arrays;

/**
 * 给出一些会议时间安排，问最少需要多少间会议室
 * 最大并发问题
 * {greedy},{two pointers},{classic}
 */
public class _253Solution {
    /**
     * 为了求最少会议室，只需要知道某一时间段同时开会的会议的数量
     * 的最大可能值,任务的峰值
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
        // 其实是一个双指针或者变长的滑动窗口
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endsItr])
                rooms++;
            else
                // 窗口向右移动，但是只有一个区间出窗口
                // 右侧线向右移动的时候starts[i]没有进行是否增加并发的比较
                // 因为右边界向右移动，表示上一个右边界对应区间不再考虑
                // 最多的rooms-1
                // 而当前的starts[i]代表一个新的并发数
                // rooms增加1个同时减少一个，所以总数量不变
                endsItr++;
        }
        return rooms;
    }

    /**
     * 使用差分数组，但是因为区间的取值范围比较大10的6次方，所以耗时很长
     * 这种情况下不适合使用差分数组
     * 
     * @param intervals
     * @return
     */
    public int minMeetingRooms1(int[][] intervals) {

        int count[] = new int[1000001];
        for (int i[] : intervals) {
            count[i[0]]++;
            count[i[1]]--;
        }
        int max = 1;
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
            max = Math.max(count[i], max);
        }
        return max;
    }
}
