package leetcode.a700;

import java.util.LinkedList;
import java.util.List;
/**
 * 日程表里面添加记录
 */
public class _729Solution {

    class MyCalendar {
        List<int[]> booked;

        public MyCalendar() {

            booked = new LinkedList<>();

        }

        /**
         * 链表实现，判断是否能插入需要on的时间复杂度，整体需要on2的时间复杂度
         * 对于测试集很慢
         * @param start
         * @param end
         * @return
         */
        public boolean book(int start, int end) {

            int i = 0;
            while (i < booked.size()) {
                if (booked.get(i)[1] <= start)
                    i++;
                else    
                    break;
            }
            if (i == booked.size()) {
                booked.add(new int[] { start, end });
                return true;
            }
            if (booked.get(i)[0] >= end) {
                booked.add(i, new int[] { start, end });
                return true;
            }
            return false;

        }
    }

    public static void main(String[] args){
        _729Solution so = new _729Solution();
        MyCalendar cal = so.new MyCalendar();
        //10,20],[15,25],[20,30]
        cal.book(10,20);
        cal.book(15,25);
        cal.book(20,30); 
    }
}
