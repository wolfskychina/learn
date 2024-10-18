package leetcode.a1400;

import java.util.ArrayList;
import java.util.List;
/**
 * 重新格式化字符串
 * {easy}
 */
public class _1417Solution {

    public String reformat(String s) {

        List<Character> letter = new ArrayList<>();
        List<Character> num = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num.add(c);
            } else {
                letter.add(c);
            }
        }
        int numL = letter.size();
        int numN = num.size();

        if (Math.abs(numL - numN) != 0 && Math.abs(numL - numN) != 1)
            return "";

        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (numL >= numN) {
            while (i < numN) {
                sb.append(letter.get(i));
                sb.append(num.get(i));
                i++;
            }
            if (numL > numN)
                sb.append(letter.get(i));
        } else {
            while (i < numL) {

                sb.append(num.get(i));
                sb.append(letter.get(i));
                i++;
            }
            sb.append(num.get(i));

        }

        return sb.toString();

    }

    public static void main(String[] args){

        _1417Solution so = new _1417Solution();
        so.reformat("a0b1c2");
    }
}
