package leetcode.a200;
/**
 * 判断一个字符串能否通过字符重排列变成一个回文串
 * {easy}
 */
public class _266Solution {
   
    public boolean canPermutePalindrome(String s) {
        int[] letters = new int[26];
        for(char c: s.toCharArray()){
            letters[c - 'a']++;
        }
        int odds = 0;
        for(int num: letters){
            if(num % 2 == 1) odds++;
        }
        return odds < 2;
    }
}
