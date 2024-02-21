package leetcode.a1000;
/**
 * 健身计划评估
 * {easy}
 */
public class _1176Solution {
   
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

        int i=0;
        int sum = 0;
        int tmp =0;
        for(;i<k;i++){
            
            tmp+=calories[i];
        }
        if(tmp>upper) 
            sum+=1;
        if(tmp<lower)
            sum-=1;
        int l =0;
        for(;i<calories.length;i++,l++){
            tmp+=calories[i];
            tmp-=calories[l];
            if(tmp>upper) 
            sum+=1;
        if(tmp<lower)
            sum-=1;
        }

        return sum;
    }
}
