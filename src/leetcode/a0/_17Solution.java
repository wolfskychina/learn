package leetcode.a0;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 根据键盘的输出生成所有可能的字符串序列
 * {backtrace}
 */
public class _17Solution {

    public List<String> letterCombination(String digits){

        LinkedList<String> ans =new LinkedList<>();
        String[] mapping = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        if(digits.length() == 0) return ans;

        for(int i=0;i<digits.length();i++){

            int x=Character.getNumericValue(digits.charAt(i));

            while(ans.peek() == null || ans.peek().length()==i){
                // LinkedList作为双向队列使用 
                String t = ans.peek() ==null?"":ans.remove();
                for(char a: mapping[x].toCharArray()){
                    ans.add(t+a);
                }
            }
        }

        return ans;
    }
}
