package leetcode.a300;

import java.util.ArrayList;
import java.util.List;

/**
 * 包含左右括号和字母的字符串，删除最少的括号使字符串成为合格的括号组合的字符串
 * 返回所有可能的解
 * {backtrack}
 * 
 */
public class _301Solution {

    private List<String> res = new ArrayList<String>();

    /**
     * 使用回溯法，当多余的左右括号数量均降为0的时候，判断括号是不是合法的
     * 
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        int lremove = 0;
        int rremove = 0;

        // 求多余的左右括号的数量
        // 类似于投票算法的思想
        // 开始的时候左右应该只有一个数量不为0
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lremove++;
            } else if (s.charAt(i) == ')') {
                if (lremove == 0) {
                    rremove++;
                } else {
                    lremove--;
                }
            }
        }
        helper(s, 0, lremove, rremove);

        return res;
    }

    private void helper(String str, int start, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isValid(str)) {
                res.add(str);
            }
            return;
        }

        for (int i = start; i < str.length(); i++) {
            // 剪枝,避免重复搜索跟前一个一样的字符
            if (i != start && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            // 如果剩余的字符无法满足去掉的数量要求，直接返回
            if (lremove + rremove > str.length() - i) {
                return;
            }
            // 尝试去掉一个左括号
            if (lremove > 0 && str.charAt(i) == '(') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove - 1, rremove);
            }
            // 尝试去掉一个右括号
            if (rremove > 0 && str.charAt(i) == ')') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove, rremove - 1);
            }
        }
    }

    /**
     * 判断是否合法括号
     * 投票算法
     * 感觉像一个模拟栈
     * {voting}
     * 
     * @param str
     * @return
     */
    private boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '(':
                    cnt++;
                    break;
                case ')':
                    cnt--;
                    if (cnt < 0)
                        return false;
                default:
                    break;
            }
        }

        return cnt == 0;
    }
}
