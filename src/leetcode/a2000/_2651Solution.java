package leetcode.a2000;
/**
 * 计算列车到达时间
 * {easy}
 */
public class _2651Solution {
   
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime+delayedTime)%24;
    }
}
