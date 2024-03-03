package leetcode.a2000;
/**
 * 数组元素和与数位和的绝对差
 * {easy}
 */
public class _2535Solution {
   
    public int differenceOfSum(int[] nums) {

        int sum =0;
        for(int i:nums){

            sum+=i;
            while(i!=0){
                sum-=i%10;
                i/=10;
            }
        }
        return sum;
    }
}
