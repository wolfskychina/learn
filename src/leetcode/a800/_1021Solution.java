package leetcode.a800;

/**
 * 删除每个合法括号字符子串的最外层的括号
 * {easy}
 */
public class _1021Solution {

    public String removeOuterParentheses(String s) {

        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        int idx = 0;
        char[] arr = s.toCharArray();
        while (idx < s.length()) {
            int start = idx;
            left = 0;
            right = 0;
            while (idx < s.length()) {
                if (arr[idx] == '(')
                    left++;
                else
                    right++;
                if (left == right) {
                    sb.append(s.substring(start + 1, idx));
                    break;
                }
                idx++;
            }
            idx++;

        }
        return sb.toString();
    }

    public String removeOuterParentheses1(String S) {

        StringBuilder sb = new StringBuilder();

        int counter = 0;

        for (char c : S.toCharArray()) {
            if ('(' == c) {
                if (++counter > 1)
                    sb.append(c);
            } else {
                if (counter-- > 1)
                    sb.append(c);
            }
        }

        return sb.toString();
    }
}
