package leetcode.a800;
/**
 * 替换字符串所能得到的最少位数
 * {easy}
 */
public class _2696Solution {
   
    public int minLength(String s) {

        while(true){
            int l = s.length();
            s= s.replace("AB", "");
            s= s.replace("CD", "");

            if(l==s.length())   return l;
        }
    }
}
