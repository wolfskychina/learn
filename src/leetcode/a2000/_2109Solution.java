package leetcode.a2000;

/**
 * 向字符串添加空格
 * {easy}
 */
public class _2109Solution {

    public String addSpaces(String s, int[] spaces) {

        int last = 0;
        StringBuilder sb = new StringBuilder();
        for (int i : spaces) {

            sb.append(s.substring(last, i)).append(" ");
            last = i;
        }
        sb.append(s.substring(last));
        return sb.toString();
    }
}
