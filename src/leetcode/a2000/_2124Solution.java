package leetcode.a2000;
/**
 * 检查有一个由字符ab构成的字符串，是否全部的a都在b的前面
 * {easy}
 */
public class _2124Solution {
   
    public boolean checkString(String s) {
        // aaabb
        int idxa = -1;
        int idxb = -1;
        boolean isfirst = true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a')
                idxa =i;
            if(isfirst&&s.charAt(i)=='b'){
                isfirst = false;
                idxb = i;
            }
            
        }
        if(idxa==-1||idxb==-1)
            return true;
        return idxa<idxb;
    }
}
