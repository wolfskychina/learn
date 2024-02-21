package leetcode.a2000;
/**
 * 找出字符串数组中的第一个回文串
 * {easy}
 */
public class _2108Solution {
   
    public String firstPalindrome(String[] words) {

        for(String str:words){
            if(isparlindrome(str))
                return str;
        }

        return "";
    }

    private boolean isparlindrome(String str){

        char[] arr = str.toCharArray();

        for(int i=0;i<arr.length/2;i++){
            if(arr[i]!=arr[arr.length-1-i])
                return false;
        }

        return true;
    }
}
