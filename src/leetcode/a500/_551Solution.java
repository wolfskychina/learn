package leetcode.a500;
/**
 * 判断出勤记录是否合格
 * {easy}
 */
public class _551Solution {

    public boolean checkRecord(String s) {

        char[] array = s.toCharArray();
        int totalA = 0;
        int contiL = 0;
        for (char c : array) {

            if (c == 'A') {
                totalA++;
                contiL = 0;

                if (totalA == 2)
                    return false;
            } else if (c == 'L') {
                contiL++;
                if (contiL == 3)
                    return false;
            } else {
                contiL = 0;
            }

        }

        return true;
    }
}
