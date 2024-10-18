package leetcode.a1100;
/**
 * 括号的最大嵌套深度
 * {easy}
 */
public class _1614Solution {
   
    /**
     * 模拟栈{stack}
     * @param s
     * @return
     */
    public int maxDepth(String s) {

        char[] str = s.toCharArray();
        int tmp =0;
        int max =0;
        for(int i=0;i<str.length;i++){

            if(str[i]=='('){
                tmp++;
            }else if(str[i]==')'){
                max = Math.max(max,tmp);
                tmp--;
            }
        }
        return max;
    }
}
