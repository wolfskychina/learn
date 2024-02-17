package leetcode.a800;
/**
 * 字符串中的最大奇数
 */
public class _1903Solution {
   
    public String largestOddNumber1(String num) {

        char[] arr = num.toCharArray();
        int i=num.length()-1;
        for(;i>=0;i--){
            if((arr[i]-'0')%2==1){
                return num.substring(0,i+1);
            }
        }
        return "";
    }

     public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((int) num.charAt(i) % 2 == 1)
                return num.substring(0, i + 1);
        }
        return "";
    }
}
