package leetcode.a2000;
/**
 * 可被三整除的偶数的平均值
 * {easy}
 */
public class _2455Solution {
   
    public int averageValue(int[] nums) {
        int count=0;
        int sum =0;
        for(int i:nums){

            if(i%6==0){
                count++;
                sum+=i;
            }
        }

        if(count==0) return 0;
        return sum/count;
    }
}
