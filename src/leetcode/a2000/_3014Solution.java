package leetcode.a2000;
/**
 * 在允许重新映射电话号码键的情况下
 * 输入不同的字符所需要的最少按键次数
 * {easy}
 */
public class _3014Solution {
   
    public int minimumPushes(String word) {

        int n = word.length();
        if(n<=8){
            return n;
        }else if(n>8&&n<=16){
            return 8+2*(n-8);
        }else if(n>16&&n<=24){
            return 24+3*(n-16);
        }else {
            return 48+4*(n-24);
        }
    }
}
