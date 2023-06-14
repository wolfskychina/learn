package leetcode.array;

import java.util.LinkedList;
import java.util.List;

public class _17Solution {

    public List<String> letterCombination(String digits){

        LinkedList<String> ans =new LinkedList<>();
        String[] mapping = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        if(digits.length() == 0) return ans;

        for(int i=0;i<digits.length();i++){

            int x=Character.getNumericValue(digits.charAt(i));

            while(ans.peek() == null || ans.peek().length()==i){
                String t = ans.peek() ==null?"":ans.peek();
                for(char a: mapping[x].toCharArray()){
                    ans.add(t+a);
                }
            }
        }

        return ans;
    }
}
