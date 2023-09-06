package leetcode.a0;

/**
 * 将两个数组合并，其中数组A的空间足够大
 */
public class _88Solution {
   
    public   void merge(int A[], int m, int B[], int n) {
        int p = m-1, q = n-1, i = m+n-1;
        while ( q>=0 ) {
            if ( p<0 || B[q] >= A[p] )
                A[i--] = B[q--];
            else
                A[i--] = A[p--];
        }
    }
}
