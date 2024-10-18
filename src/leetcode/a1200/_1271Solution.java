package leetcode.a1200;

import java.util.HashMap;
import java.util.Map;
/**
 * 转换为十六进制后是否为magic数
 * {easy}
 */
public class _1271Solution {

    private static Map<Integer, Character> map = new HashMap<>();

    public _1271Solution() {
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');
        map.put(1, 'I');
        map.put(0, 'O');
    }

    public String toHexspeak(String num) {
        Long o = Long.parseLong(num);

        StringBuilder sb = new StringBuilder();
        while (o != 0) {
            if (map.get((int) (o % 16)) == null)
                return "ERROR";
            sb.append(map.get((int) (o % 16)));
            o /= 16;
        }

        return sb.reverse().toString();

    }

    public String toHexspeak1(String num) {
        long n = Long.parseLong(num);
        char[] s = Long.toHexString(n).toCharArray();
        for (int i = 0; i < s.length; ++i) {
            if ('2' <= s[i] && s[i] <= '9')
                return "ERROR";
            if (s[i] == '1')
                s[i] = 'I';
            else if (s[i] == '0')
                s[i] = 'O';
            else
                s[i] += 'A' - 'a';
        }
        return new String(s);
    }

}
