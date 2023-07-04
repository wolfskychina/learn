package leetcode.array;

import java.util.LinkedList;
/**
 * 将路径字符串简化
 */
public class _71Solution {

    public String simplifyPath(String path){
        StringBuilder sb = new StringBuilder("/");
        LinkedList<String> stack = new LinkedList<>();
        for(String s: path.split("/")){

            if(s.equals("")||s.equals(".")) continue;
            if(s.equals("..")&& !stack.isEmpty()) {
                stack.removeLast();
            }else{
                if(!s.equals("..")){
                    stack.add(s);
                }
            }

        }

        for(String s : stack) sb.append(s+"/");

        if(!stack.isEmpty()) sb.setLength(sb.length()-1);

        return sb.toString();
    }
}
