package leetcode.a2000;
/**
 * 数字num的k-beauty子串的数目
 * {easy}
 */
public class _2269Solution {
   
    public int divisorSubstrings(int num, int k) {
        int count=0;
        String str = String.valueOf(num);
        for(int i=0;i<str.length()-k+1;i++){

            int n = Integer.parseInt(str.substring(i, i+k));
            if(n==0) continue;
            if(num%n==0) count++;
        }

        return count;
    }
}
