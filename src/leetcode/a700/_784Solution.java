package leetcode.a700;

import java.util.ArrayList;
import java.util.List;
/**
 * 字母大小写的排列组合
 */
public class _784Solution {

    List<String> res = new ArrayList<>();
    /**
     * {backtrace},{easy}
     * @param s
     * @return
     */
    public List<String> letterCasePermutation(String s) {

        
        formString(s,0,new StringBuilder(),res);

        return res;
    }

    private void formString(String s, int i, StringBuilder sb, List<String> res2) {

        if(i == s.length()){
            res.add(sb.toString());
            return ;
        }

        char c = s.charAt(i);
        sb.append((char)c);
        formString(s, i+1, sb, res2);
        sb.setLength(sb.length()-1);

        if(c>='a'&&c<='z'){
            sb.append((char)(c+'A'-'a'));
            formString(s,i+1,sb,res2);
            sb.setLength(sb.length()-1);
        }else if(c>='A'&&c<='Z'){
            sb.append((char)(c-'A'+'a'));
            formString(s, i+1, sb, res2);
            sb.setLength(sb.length()-1);
        }
    }
}
