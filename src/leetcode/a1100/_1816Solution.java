package leetcode.a1100;
/**
 * 截断句子
 * {easy}
 */
public class _1816Solution {
   
    public String truncateSentence(String s, int k) {
        int i=0;
        for(char c:s.toCharArray()){
            if(c==' '){
                k--;
                if(k==0) break;
            }
            i++;
        }
        if(i==s.length()) return s;
        return s.substring(0,i);
    }
}
