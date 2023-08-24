package leetcode.a300;

import java.util.Arrays;
/**
 * 判断一个时间安排是否有冲突
 * 是否有重叠的区间
 */
public class _252Solution {
    public boolean canAttendMeetings(int[][] intervals) {
      
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
         for(int i=1;i<intervals.length;i++){
             if(intervals[i-1][1]>intervals[i][0]){
                 return false;
             }
         }
         return true;
  } 
}
