package leetcode.a1000;
/**
 * 统计所有只含有一种字符的子串的数量
 * {easy}
 */
public class _1180Solution {
   
    public int countLetters(String s) {

        char[] arr = s.toCharArray();
        int i=0;
        int  j=0;
        int count=0;
        while(j<arr.length){
            while(j<arr.length&&arr[j]==arr[i]){
                j++;
            }
            count += (j-i)*(j-i+1)/2;
            i=j;
        }
        return count;
    }
}
