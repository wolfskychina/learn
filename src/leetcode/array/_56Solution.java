package leetcode.array;

import java.util.*;

public class _56Solution {

    public class Interval{

        public int start;
        public int end;

    }

    public List<Interval> merge(List<Interval> intervals){

/*         Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;

            }
        }); */

        intervals.sort((a, b) -> a.start - b.start);

        LinkedList<Interval> merged = new LinkedList<>();
        for(Interval interval : intervals){
            if(merged.isEmpty()|| merged.getLast().end<interval.start){
                merged.add(interval);
            }else{
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }


}
