package leetcode.a2000;

/**
 * 执行子串操作后的字典序最小字符串
 * 这里的子串操作是对子串中的所有字符-1，a改成z
 * 要求只能改变一个非空子串
 * {greedy}
 */
public class _2734Solution {

    /**
     * 只能改从左往右第一个非a开头的子串
     * 如果没有这样的子串，说明全是a，改最后面的a，结果最大
     * @param s
     * @return
     */
    public String smallestString(String s) {

        int i = 0;
        StringBuilder sb = new StringBuilder();
        boolean changed = false;

        while (i < s.length() && s.charAt(i) == 'a') {
            sb.append(s.charAt(i++));
        }

        while (i < s.length() && s.charAt(i) != 'a') {
            changed = true;
            sb.append((char) (s.charAt(i++) - 1));
        }

        while (i < s.length()) {
            sb.append(s.charAt(i++));
        }

        if (changed)
            return sb.toString();
        return sb.substring(0, sb.length() - 1) + "z";

    }
}
