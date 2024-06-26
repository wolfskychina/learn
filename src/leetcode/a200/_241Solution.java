package leetcode.a200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一组包括+ - * 号的表达式，问根据不同的加括号方法，总共有多少种结果
 * 结果的值可以是重复的，数量以括号不同位置区分
 * {binary tree}
 */
public class _241Solution {

    /**
     * 用二叉树的结构抽象加括号的计算，节点为运算符号，左右子树分别为符号表达式的左右两端
     * 根节点表示该符号和左右相邻的数字是最里面的括号，最先计算，以此类推
     */
    private Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        int len = input.length();
        // check history
        List<Integer> result = memo.get(input);
        if (result != null) { return result; }
        result = new ArrayList<>();
        // base case
        if (isDigit(input)) {
            result.add(Integer.parseInt(input));
            memo.put(input,result);
            return result;
        }
        // recursion (divid & conquer)
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            // 只有中间是符号的时候才需要计算
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1,len));
                for (Integer il : left) {
                    for (Integer ir : right) {
                        switch (c) {
                            case '+': result.add(il + ir); break;
                            case '-': result.add(il - ir); break;
                            case '*': result.add(il * ir); break;
                        }
                    }
                }
            }
        }
        memo.put(input,result);
        return result;
    }
    private boolean isDigit(String s) {
        for (Character c : s.toCharArray()) {
            if (!Character.isDigit(c)) { return false; }
        }
        return true;
    }
}
