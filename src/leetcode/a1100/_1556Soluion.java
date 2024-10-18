package leetcode.a1100;
/**
 * 给数组增加千位分隔符
 * 注意n==0的时候需要特殊处理
 */
public class _1556Soluion {

    public String thousandSeparator(int n) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (n == 0)
            return "0";
        while (n != 0) {

            if (i == 0) {
                sb.append(".");
            }
            sb.append((int) (n % 10));
            n = n / 10;

            i = (i + 1) % 3;

        }

        sb.reverse().setLength(sb.length() - 1);
        return sb.toString();

    }
}
