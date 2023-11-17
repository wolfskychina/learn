package leetcode.a600;
/**
 * 字符串中回文子串的数量
 */
public class _647Solution {
   
    /**
     * 中心扩展
     * {panlindrome}
     * @param s
     * @return
     */
    public int countSubstrings(String s) {

        char[] arr = s.toCharArray();
        int sum = 0;

        for(int i=0;i<arr.length;i++){

            sum+= countPalindromic(arr,i,i);
            sum+= countPalindromic(arr, i,i+1);
        }

        return sum;

    }

    private int countPalindromic(char[] arr, int i, int j) {
        int count =0;
        while(i>=0&&j<arr.length&&arr[i]==arr[j]){
            count++;
            i--;
            j++;
        }
        return count;
    }
}
