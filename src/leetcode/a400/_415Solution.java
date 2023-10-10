package leetcode.a400;
/**
 * 字符串加法
 */
public class _415Solution {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        String tmp;
        if (num1.length() < num2.length()) {
            tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        char carry = '0';
        int i = num1.length()-1;
        for (int j = num2.length()-1; j >= 0; j--, i--) {
            // 单位相加的结果
            int add = carry + num1.charAt(i) + num2.charAt(j) - '0' - '0' - '0';
            sb.append((char) ('0' + add % 10));
            if (add >= 10) {
                carry = '1';

            } else {
                carry = '0';
            }

        }

        for (; i >= 0; i--) {

            int add = carry + num1.charAt(i) - '0' -'0';
            sb.append((char) ('0' + add % 10));
            if (add >= 10) {
                carry = '1';

            } else {
                carry = '0';
            }

        }

        if (carry == '1')
            sb.append('1');
        return sb.reverse().toString();

    }
}
