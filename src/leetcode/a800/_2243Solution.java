package leetcode.a800;
/**
 * 字符串的数字和
 * {easy}
 */
public class _2243Solution {
   
    public String digitSum(String s, int k) {

        while(s.length()>k){
            String ss = "";
            for(int i=0;i<s.length();i+=k){
                int tmp = 0;
                for(int j=i;j<s.length()&&j<i+k;j++){
                    tmp+= s.charAt(j)-'0';
                }
                ss = ss+String.valueOf(tmp);
            }
            s =ss;
        }

        return s;
    }
}
