package leetcode.a3000;

import java.util.Arrays;

/**
 * 将数组变相同的最小代价
 * 允许两种操作，一种是将数组元素任意排序，代价是k
 * 第二种操作是改动每个元素大小，代价是元素变化值
 * 
 * {greedy}
 */
public class _3424Solution {
   
    public long minCost(int[] arr, int[] brr, long k) {
        
        long sum1 =0L;
        for(int i=0;i<arr.length;i++){
            sum1+=Math.abs(arr[i]-brr[i]);
        }
        // 优化，如果变动值比k小，就不用更改元素的顺序
        if(sum1<=k) return sum1;
        long sum2 = 0L;
        Arrays.sort(arr);
        Arrays.sort(brr);
        for(int i=0;i<arr.length;i++){
            sum2+=Math.abs(arr[i]-brr[i]);
        }
        if(sum1==sum2) return sum1;
        return Math.min(sum1,sum2+k);
    }

    public static void main(String[] args){
        _3424Solution so = new _3424Solution();
        int[] arr ={-7,9,5};
        int[] brr ={7,-2,-5};
        so.minCost(arr, brr, 2);
    }
}
