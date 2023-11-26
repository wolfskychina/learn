package leetcode.a700;
/**
 * 大写字母转换成小写字母
 * 
 */
public class _709Solution {

    public String toLowerCase(String s) {

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {

            if (c >= 'A' && c <= 'Z')
                // 注意java会自动将字符的运算转换成int
                // append的时候需要强制转换会char
                // 否则会添加整数的字符串形式
                sb.append((char) (c - 'A' + 'a'));

            else
                sb.append(c);
        }

        return sb.toString();

    }
}
