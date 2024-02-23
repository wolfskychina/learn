package leetcode.a2000;

/**
 * 字符串中最大的三位相同的数字
 * {easy}
 */
public class _2264Solution {

    public String largestGoodInteger(String num) {

        int count[] = new int[10];
        char[] arr = num.toCharArray();
        for (int i = 0; i < arr.length - 2; i++) {

            if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2]) {
                count[arr[i] - '0']++;
            }
        }

        for (int i = 9; i >= 0; i--) {
            if (count[i] != 0)
                return "" + (char) ('0' + i) + (char) ('0' + i) + (char) ('0' + i);
        }

        return "";
    }

    public String largestGoodInteger1(String num) {
        if (num.contains("999"))
            return "999";
        if (num.contains("888"))
            return "888";
        if (num.contains("777"))
            return "777";
        if (num.contains("666"))
            return "666";
        if (num.contains("555"))
            return "555";
        if (num.contains("444"))
            return "444";
        if (num.contains("333"))
            return "333";
        if (num.contains("222"))
            return "222";
        if (num.contains("111"))
            return "111";
        if (num.contains("000"))
            return "000";
        return "";
    }
}
