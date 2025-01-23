package leetcode.a3000;

import java.util.Arrays;

/**
 * 高度各不相等的塔高和的最大值
 * {greedy},{easy}
 */
public class _3301Solution {
   
    public long maximumTotalSum(int[] maximumHeight) {
        
        long sum = 0;
        Arrays.sort(maximumHeight);

        int max = maximumHeight[maximumHeight.length-1];
        int min = 0;
        for(int i=maximumHeight.length-1;i>=0;i--){

            min = Math.min(maximumHeight[i],max);
            if(min==0) return -1;
            sum+=min;
            max = min-1;

        }

        return sum;
    }
}
