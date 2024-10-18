package leetcode.a1100;
/**
 * goal解析器
 * {easy}
 */
public class _1678Solution {
   
    public String interpret(String command) {

        return command.replace("()", "o").replace("(al)", "al");
    }
}
