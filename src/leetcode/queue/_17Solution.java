package leetcode.queue;

import java.util.LinkedList;
import java.util.List;

/**
 * 根据电话号码生成可能的字符组合
 * 有点和组合数学中的集合生成类似
 */
public class _17Solution {

    public List<String> letterCombinations(String digits) {

        LinkedList<String> ans = new LinkedList<String>();

        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if(digits.length() ==0) return ans;

        for(int i =0; i<digits.length();i++){

            int x = Character.getNumericValue(digits.charAt(i));

            while(ans.peek() == null || ans.peek().length()==i){

                String t = ans.peek() ==null ? "": ans.remove();

                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
                // poll() 和 remove() 都是从队列中取出一个元素，但是 poll() 在获取元素失败的时候会返回空，但是 remove() 失败的时候会抛出异常
            }
        }

        return ans;
    }
}
