package leetcode.a1000;
/**
 * 指定时间内做作业的学生数量
 * {easy}
 */
public class _1450Solution {
   
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int count=0;
        for(int i=0;i<startTime.length;i++){

            if(queryTime>=startTime[i]&&queryTime<=endTime[i])
                count++;
        }
        return count;

    }
}
