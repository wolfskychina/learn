package leetcode.a600;

import java.util.Arrays;

/**
 * 整数数列中三个数的乘积的最大值
 */
public class _628Solution {

    /**
     * 直观的方法，排序之后选择两侧的值
     * 注意数列中的数有可能是负数，所以不一定最大数是数列末尾的三个数相乘
     * onlogn的时间复杂度
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        if (nums[0] >= 0 || nums[nums.length - 1] <= 0)
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        // nums[0]<=0 && nums[n]>0
        // 存在两个最小负数和一个最大正数乘数最大的可能
        return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3],
                nums[0] * nums[1] * nums[nums.length - 1]);
    }

    /**
     * 根据上面的分析，其实只需要找到最小的两个数和最大的三个数即可
     * 只需要遍历数组一遍即可
     * @param nums
     * @return
     */
    public int maximumProduct1(int[] nums) {

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for(int i:nums){

            if(i<min1){
                min2 = min1;
                min1 =i;
            }else if(i>=min1 &&i<min2){
                min2 = i;
            }

            if(i>max1){
                max3 = max2;
                max2 = max1;
                max1 =i;
            }else if(i<=max1 && i>max2){
                max3 = max2;
                max2 = i; 
            }else if(i<=max2 && i>max3){
                max3 = i;
            }
            
        }

        return Math.max(max1*max2*max3,min1*min2*max1);
        
    }


}
