package leetcode.a0;

import java.util.Arrays;

public class _16Solution {

    public int threeSumClosest(int [] num, int target){
        int result = num[0] + num[1] +num[num.length-1];
        Arrays.sort(num);
        for(int i = 0;i<num.length-2;i++){
            int start = i+1;
            int end = num.length-1;
            while(start<end){
                int sum =num[i]+num[start]+num[end];
                if(sum>target){
                    end--;
                }else{
                    start++;
                }
                if(Math.abs(sum-target)<Math.abs(result-target)){
                    result = sum;
                }
            }
        }

        return result;
    }
}
