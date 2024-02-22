package leetcode.a2000;
/**
 * 转化时间所需要的最少操作次数
 * {easy}
 */
public class _2224Solution {
   
    public int convertTime(String current, String correct) {

        int cur = Integer.parseInt(current.substring(0,2))*60+Integer.parseInt(current.substring(3));
        int cor = Integer.parseInt(correct.substring(0,2))*60+Integer.parseInt(correct.substring(3));

        if(cur>cor){
            cor+=24*60;
        }

        int sub = cor-cur;
        int sum=0;
        sum+=sub/60;
        sub = sub%60;
        sum+=sub/15;
        sub = sub%15;
        sum+=sub/5;
        sub = sub%5;
        sum+=sub;

        return sum;
    }
}
