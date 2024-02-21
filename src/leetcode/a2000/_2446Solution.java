package leetcode.a2000;
/**
 * 求两个时间段是否有交集
 * {easy}
 */
public class _2446Solution {

    public boolean haveConflict(String[] event1, String[] event2) {

        int s1 = trans(event1[0]);
        int s2 = trans(event2[0]);
        int e1 = trans(event1[1]);
        int e2 = trans(event2[1]);

        if (s1 > s2) {
            int tmp = s1;
            s1 = s2;
            s2 = tmp;
            tmp = e1;
            e1 = e2;
            e2 = tmp;
        }

        return (s2 <= e1) ? true : false;

    }

    private int trans(String time){

        String [] str = time.split(":");
        return 60*Integer.parseInt(str[0])+Integer.parseInt(str[1]);


    }

    /**
     * 直接比较字符串字面大小即可
     * @param event1
     * @param event2
     * @return
     */
    public boolean haveConflict1(String[] event1, String[] event2) {
        return !(event2[0].compareTo(event1[1]) > 0 || event2[1].compareTo(event1[0]) < 0);
        }

    public static void main(String[] args){
        _2446Solution so = new _2446Solution();
        String []str1 = {"01:15","02:00"};
        String []str2 = {"02:00","03:00"};
        so.haveConflict(str1, str2);
    }
}
