package leetcode.a1000;
/**
 * 递增数组中第k个缺失的正整数 
 */
public class _1539Solution {
   
    public int findKthPositive(int[] arr, int k) {

        int mis =1;
        int count=0;
        for(int i:arr){

            while(mis<i&&count!=k){
                mis++;
                count++;
            }
            if(count==k) return mis-1;
            mis =i+1;
        }
        while(count!=k){
            mis++;
            count++;
        }

        return mis-1;
    }
}
