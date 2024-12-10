package leetcode.a900;

/**
 * 使括号有效的最少添加
 * {stack}
 */
public class _921Solution {

    /**
     * 模拟栈，并且在原数组上模拟
     * @param s
     * @return
     */
    public int minAddToMakeValid(String s) {

        int i = 0;
        char[] ss = s.toCharArray();
        for (int j = 1; j < ss.length; j++) {
            if (ss[j] == '(' || (i == -1 || ss[i] != '(')) {
                ss[++i] = ss[j];
            } else {

                i--;
            }
        }

        return i + 1;
    }
}
