package leetcode.a1100;
/**
 * 长度为3且各字符均不相同的子串
 */
public class _1876Solution {
   
    public int countGoodSubstrings(String s) {

        char [] arr = s.toCharArray();
        int count=0;
        for(int i=0;i<arr.length-2;i++){

            if(arr[i]!=arr[i+1]&&arr[i+1]!=arr[i+2]&&arr[i]!=arr[i+2])
                count++;

        }
        return count;
    }
}
