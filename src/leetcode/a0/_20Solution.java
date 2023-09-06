package leetcode.a0;

import java.util.Stack;

/**
 * 验证字符串的左右匹配是否合法
 */
public class _20Solution {

    public boolean isValid(String s) {

        Stack<Character> stack= new Stack<>();

        for(int index = 0 ;index<s.length();index++){

            if(s.charAt(index) == '(' ||
                    s.charAt(index)  == '{' ||
                    s.charAt(index) == '[')
            {
                stack.push(s.charAt(index));
                continue;
            }

            switch(s.charAt(index)){
                case ')' :
                    if(stack.empty() || (Character)stack.pop() != '(')  return false;
                    break;
                case '}' :
                    if(stack.empty() || (Character)stack.pop() != '{')  return false;
                    break;
                case ']' :
                    if(stack.empty() || (Character)stack.pop() != '[')  return false;
                    break;
            }


        }

        if(stack.empty()){
            return true;
        }else{
            return false;
        }
    }
}
