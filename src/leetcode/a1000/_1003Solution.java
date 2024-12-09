package leetcode.a1000;

/**
 * 检查替换后的词是否有效
 * s能否通过不断插入abc生成
 * {stack}
 */
public class _1003Solution {

    public boolean isValid(String s) {

        char[] stack = s.toCharArray();
        int idx = 0;
        for (char c : stack) {
            stack[idx] = c;
            if (idx > 1 && stack[idx] == 'c' && stack[idx - 1] == 'b' && stack[idx - 2] == 'a') {
                idx -= 2;
            } else {
                idx++;
            }

        }

        return idx == 0;
    }
}
