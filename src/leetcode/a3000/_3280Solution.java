package leetcode.a3000;

/**
 * 进制转换
 * {easy}
 */
public class _3280Solution {

    public String convertDateToBinary(String date) {

        String[] s = date.split("-");
        return trans(s[0]) + "-" + trans(s[1]) + "-" + trans(s[2]);
    }

    private String trans(String s) {

        int i = Integer.valueOf(s);
        if (i == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        while (i != 0) {
            sb.append((char) ('0' + i % 2));
            i /= 2;
        }
        return sb.reverse().toString();
    }
}
