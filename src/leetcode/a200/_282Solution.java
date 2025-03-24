package leetcode.a200;

import java.util.ArrayList;
import java.util.List;
/**
 * 通过给num的各个位之间插入+-*号，能否使得计算结果等于target
 * 返回所有符合条件的组合
 * {backtrace}
 * TODO 
 */
public class _282Solution {

        int n;
        String num;
        int target;
        List<String> ans;
    
        /**
         * 注意组成的数字溢出
         * @param num
         * @param target
         * @return
         */
        public List<String> addOperators(String num, int target) {
            this.n = num.length();
            this.num = num;
            this.target = target;
            this.ans = new ArrayList<String>();
            StringBuilder expr = new StringBuilder();
            backtrack(expr, 0, 0, 0);
            return ans;
        }
    
        public void backtrack(StringBuilder expr, int i, long res, long last) {
            if (i == n) {
                if (res == target) {
                    ans.add(expr.toString());
                }
                return;
            }
            int signIndex = expr.length();
            if (i > 0) {
                // 提前占下符号位的思路很巧妙
                expr.append(0); // 占位，下面填充符号
            }
            long val = 0;
            // 枚举截取的数字长度（取多少位），注意数字可以是单个 0 但不能有前导零
            for (int j = i; j < n && (j == i || num.charAt(i) != '0'); ++j) {
                val = val * 10 + num.charAt(j) - '0';
                expr.append(num.charAt(j));
                if (i == 0) {
                    // 表达式开头不能添加符号
                    backtrack(expr, j + 1, val, val);
                } else { // 枚举符号
                    expr.setCharAt(signIndex, '+');
                    // 插入符号之后，开始新一轮b从长度1开始的递归
                    backtrack(expr, j + 1, res + val, val);
                    expr.setCharAt(signIndex, '-');
                    backtrack(expr, j + 1, res - val, -val);
                    expr.setCharAt(signIndex, '*');
                    backtrack(expr, j + 1, res - last + last * val, last * val);
                }
            }
            expr.setLength(signIndex);
        }

}