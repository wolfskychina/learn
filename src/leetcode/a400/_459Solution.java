package leetcode.a400;
/**
 * 一个字符串能否通过子串重复组成
 * {easy}
 */
public class _459Solution {
   
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length()/2;
        for(int i=1;i<=len;i++){

            if(s.length()%i !=0) continue;
            String str = s.substring(0,i);
            boolean tmp = true;
            for(int start =i;start<s.length();start +=i){
                
                if(!str.equals(s.substring(start,start+i))){
                    tmp =false;
                    break;
                }
            }
            if(tmp) return true;
        }

        return false;
    }

    public static void main(String[] args){
        _459Solution so = new _459Solution();
        so.repeatedSubstringPattern("ababab");

    }
}
