package leetcode.a2000;

import java.util.Arrays;

/**
 * 使每位学生都有座位的最少总移动次数
 * {greedy}
 */
public class _2037Solution {
  
    /**
     * 排序后任选两个坐标i<j
     * 将差值带平方，可以证明不等式恒成立，保证符合贪心特性
     * @param seats
     * @param students
     * @return
     */
    public int minMovesToSeat(int[] seats, int[] students) {

        int count =0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for(int i=0;i<seats.length;i++){
            count+= Math.abs(seats[i]-students[i]);
        }
        return count;
    }
}
