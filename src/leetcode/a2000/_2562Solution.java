package leetcode.a2000;
/**
 * 数组不断将首尾数字拼接然后相加所得到的数字
 */
public class _2562Solution {
   
    public long findTheArrayConcVal(int[] nums) {

        int i=0;
        int j=nums.length-1;
        long sum =0; 
        while(i<j){

            sum+=Long.parseLong(String.valueOf(nums[i])+String.valueOf(nums[j]));

            i++;
            j--;
        }
        if(i==j){
            sum+=nums[i];
        }
        return sum;
    }

    /**
     * 更快捷的计算整数位数的方法
     * @param nums
     * @return
     */
    public long findTheArrayConcVal1(int[] nums) {
        int l = 0, r = nums.length - 1;
        long res = 0;
        while(l <= r){
            if(l == r){
                res += nums[l];
            }else{
                // TODO 方便的计算整数的位数的方法log10
                int len = (int)Math.log10(nums[r]) + 1;
                res += (long)Math.pow(10, len) * nums[l]  + nums[r];
            }
            l++;
            r--;
        }
        return res;
    }
}
