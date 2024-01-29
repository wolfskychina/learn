package leetcode.a800;

import java.util.Arrays;
/**
 * 字符串中所有字符到特定字符的距离
 * {easy}
 */
public class _821Solution {
   
    public int[] shortestToChar(String s, char c) {

        char[] arr = s.toCharArray();
        int count[] = new int[arr.length];
        Arrays.fill(count, Integer.MAX_VALUE);
        for(int i=0;i<arr.length;i++){

            if(arr[i] == c){
                count[i] = 0;
                for(int j=i-1,dis =1;j>=0&&arr[j]!=c;j--,dis++){
                    count[j] = Math.min(count[j],dis);
                }
                for(int k=i+1,dis=1;k<arr.length&&arr[k]!=c;k++,dis++){
                    count[k] = Math.min(count[k],dis);
                }
            }
        }
        return count;
    }
}
