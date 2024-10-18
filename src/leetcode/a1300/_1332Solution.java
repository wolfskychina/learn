package leetcode.a1300;
/**
 * 一个只有a和b组成的字符串，可以最少删除多少个回文子序列
 * 将s变成空字符串
 * {easy}
 */
public class _1332Solution {
   
    public int removePalindromeSub(String s) {

        return isPalindrome(s)?1:2;
    }

    private boolean isPalindrome(String s){

        char[] str = s.toCharArray();
        for(int i=0;i<str.length/2;i++){
            if(str[i]!=str[str.length-i-1])
                return false;
        }
        return true;
    }
}
