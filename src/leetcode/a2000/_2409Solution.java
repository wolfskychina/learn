package leetcode.a2000;
/**
 * 统计共同度过的日子
 * {easy}
 */
public class _2409Solution {
    
    private int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        if(leaveAlice.compareTo(arriveBob)<0||
            leaveBob.compareTo(arriveAlice)<0)
                return 0;
        if(arriveAlice.compareTo(arriveBob)>0){
            String tmp = arriveAlice;
            arriveAlice = arriveBob;
            arriveBob = tmp;
        }
      
        String end = leaveAlice.compareTo(leaveBob)>0?leaveBob:leaveAlice;

        int startmonth = Integer.parseInt(arriveBob.split("-")[0]);
        int startday = Integer.parseInt(arriveBob.split("-")[1]);

        int endmonth = Integer.parseInt(end.split("-")[0]);
        int endday = Integer.parseInt(end.split("-")[1]);

        int days = 0;

        for(int i=startmonth;i<endmonth;i++){
            days+=month[i-1];
        }
        days += endday-startday+1;
        return days;

    }
}
