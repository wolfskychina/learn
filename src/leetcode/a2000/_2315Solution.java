package leetcode.a2000;
/**
 * 统计两个|之外的*号数量
 * {easy}
 */
public class _2315Solution {
   
    public int countAsterisks(String s) {

        boolean open = true;
        int count =0;
        for(char c:s.toCharArray()){

            if(open&&c == '*'){
                count++;
            }

            if(c=='|'){
                open = open==true?false:true;
            }
        }

        return count;
    }
}
