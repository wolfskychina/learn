package leetcode.a1000;

import java.util.Stack;
/**
 * 不断循环，去掉字符串中相邻且相同的字符
 */
public class _1047Solution {
   
    /**
     * {stack}
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(stack.isEmpty()||stack.peek()!=c)
                stack.push(c);
            else{
                while(!stack.isEmpty()&&stack.peek()==c){
                    stack.pop();
                }
            }
          
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        
        return sb.reverse().toString();
    }

    /**
     * {two poiters}快慢指针更加巧妙
     */
    public String removeDuplicates1(String s) {
        char[] ch = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while(fast < s.length()){
            // 直接用fast指针覆盖slow指针的值
            ch[slow] = ch[fast];
            // 遇到前后相同值的，就跳过，即slow指针后退一步，下次循环就可以直接被覆盖掉了
            if(slow > 0 && ch[slow] == ch[slow - 1]){
                slow--;
            }else{
                slow++;
            }
            fast++;
        }
        return new String(ch,0,slow);
    }
}
