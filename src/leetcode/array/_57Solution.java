package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class _57Solution {

    public int[][] insert(int[][] intervals, int[] newInterval){

        int start = newInterval[0];
        int end = newInterval[1];
        List<int[]> list = new ArrayList<>();

        for(int[] interval:intervals){

            int curStart = interval[0];
            int curEnd = interval[1];

            if(curEnd<start){
                list.add(new int[]{curStart, curEnd});
            }else if(curStart>end){
                list.add(new int[]{start, end});
                start = curStart;
                end = curEnd;
            }else{
                start = Math.min(start, curStart);
                end = Math.max(end, curEnd);
            }
        }

        list.add(new int[]{start, end});
        return list.toArray(new int[intervals.length][2]);
    }
}
