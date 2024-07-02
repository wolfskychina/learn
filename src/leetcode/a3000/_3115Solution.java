package leetcode.a3000;

/**
 * 数组中质数所在位置的最大距离
 * {easy},{prime}
 */
public class _3115Solution {
   
    public int maximumPrimeDifference(int[] nums) {
        int l =-1;
        int r =-1;
        for(int i=0;i<nums.length;i++){

            if(isPrime(nums[i])){
                if(l==-1){
                    l = i;
                }else{
                    r =i;
                }
            }
        }

        return r==-1?0:r-l;
    }

    private boolean isPrime(int i){

        if(i<=1) return false;

        for(int j=2;j*j<=i;j++){
            
            if(i%j==0) return false;
        }

        return true;
    }

}
