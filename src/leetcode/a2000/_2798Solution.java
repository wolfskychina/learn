package leetcode.a2000;
/**
 * 满足目标工作时长的员工
 * {easy}
 */
public class _2798Solution {
   
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {

        int count =0;
        for(int i:hours){
            if(i>=target){
                count++;
            }
        }
        return count;
    }
}
