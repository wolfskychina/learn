package leetcode.a2000;

/**
 * 将各数位重新排列所能形成的最大二进制奇数
 * {easy}
 */
public class _2864Solution {

    public String maximumOddBinaryNumber(String s) {

        int n = s.length();
        int count = 0;
        for (char c : s.toCharArray()) {

            if (c == '1')
                count++;
        }
        count--;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("1");
        }
        for (int i = 0; i < n - count - 1; i++) {
            sb.append("0");
        }
        return sb.append("1").toString();

    }
}
