package leetcode.a1000;
/**
 * 判断某一天是一年中的第几天
 * {easy}
 */
public class _1154Solution {
   
    private   int monthd [] = {0,31,28,31,30,31,30,31,31,30,31,30,31,30};

    public int dayOfYear(String date) {

        String[] str = date.split("-");
        int num = Integer.parseInt(str[2]);
        for(int i=1;i<Integer.parseInt(str[1]);i++){
            num+=monthd[i];
        }
        int year = Integer.parseInt(str[0]);
        if(Integer.parseInt(str[1])>2&&((year%100==0&&year%400==0)||(year%100!=0&&year%4==0)))
            num++;
        return num;
    }
}
