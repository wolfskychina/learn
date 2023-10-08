package leetcode.a400;

import java.util.ArrayList;
import java.util.List;

public class _401Solution {

    int[] hours = new int[] { 1, 2, 4, 8, 0, 0, 0, 0, 0, 0 };
    int[] minutes = new int[] { 0, 0, 0, 0, 1, 2, 4, 8, 16, 32 };
    List<String> res = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        backtrack(num, 0, 0, 0);
        return res;
    }

    public void backtrack(int num, int index, int hour, int minute) {
        // none valid
        if (hour > 11 || minute > 59)
            return;

        // found one ans
        if (num == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(':');
            if (minute < 10) {
                sb.append('0');
            }
            sb.append(minute);
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < 10; i++) {
            backtrack(num - 1, i + 1, hour + hours[i], minute + minutes[i]);
        }
    }
}
