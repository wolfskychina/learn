package leetcode.a1000;
/**
 * 能够能拼出气球的字符的最大数量
 * {easy}
 */
public class _1189Solution {
   
    public int maxNumberOfBalloons(String text) {

        char[] arr= new char[26];
        for(char c:text.toCharArray()){
            arr[c-'a']++;
        }
        int min = Integer.MAX_VALUE;
        min = Math.min(min,arr['b'-'a']);
        min = Math.min(min,arr[0]);
        min = Math.min(min,arr['n'-'a']);
        min = Math.min(min,arr['l'-'a']/2);
        min = Math.min(min,arr['o'-'a']/2);
        return min;
    }
}
