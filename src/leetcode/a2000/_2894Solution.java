package leetcode.a2000;
/**
 * 分类求和并作差
 * {easy}
 */
public class _2894Solution {
   
    public int differenceOfSums(int n, int m) {

        if(m>n) return n*(n+1)/2;
        if(m==n) return n*(n+1)/2-2*m;

        int k=n/m;

        return n*(n+1)/2-k*(k+1)*m;

    }
}
