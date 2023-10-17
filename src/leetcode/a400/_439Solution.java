package leetcode.a400;
/**
 * 模拟三元组表达式的解析
 * TODO
 */
public class _439Solution {

    /**
     * 类似于括号，只有配对之后才能计算最右侧的表达式值
     * ??::express , ?:express , 都是先计算express
     * @param expression
     * @return
     */
    public String parseTernary(String expression) {
        int n = expression.length();
        int checkLevel = 0;
        for (int j = 1; j < n; j++) {
            if (expression.charAt(j) == '?')
                checkLevel++;
            if (expression.charAt(j) == ':')
                checkLevel--;
            if (checkLevel == 0)
                return (expression.charAt(0) == 'T') ? parseTernary(expression.substring(2, j))
                        : parseTernary(expression.substring(j + 1, n));
        }
        return expression;
    }

    public static void main(String[] args) {
        _439Solution so = new _439Solution();
        System.out.println(so.parseTernary("T?2:3"));

    }
}
