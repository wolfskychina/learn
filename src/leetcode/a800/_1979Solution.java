package leetcode.a800;
/**
 * {gcd},{easy}
 */
public class _1979Solution {
   
    public int findGCD(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i:nums){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        return gcd(max,min);
    }

    private int gcd(int a,int b){

        while(a%b!=0){
            int tmp = a%b;
            a=b;
            b=tmp;
        }
        return b;
    }
}
