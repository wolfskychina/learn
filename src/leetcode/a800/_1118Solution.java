package leetcode.a800;
/**
 * 某个月有多少天
 * {easy}
 */
public class _1118Solution {
   
    private static int [] map = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public int numberOfDays(int year, int month) {

        if(month!=2) return map[month];
        if(year%4==0&&((year%100==0&&year%400==0)||(year%100!=0)))
            return 29;
        return 28;
    }
}
