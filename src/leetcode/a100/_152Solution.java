package leetcode.a100;
/**
 * 求一个数组中各位数乘积最大的子数组
 */
public class _152Solution {
   
    /**
     * 贪心规则的思路：
     * 只要数组里面没有0，那么最大的子数列必然能够
     * 到达最左侧或者最右侧。如果有0，那么到达0的时候乘积清零，
     * 所以0可以作为一个边界。
     * {greedy}
     * on时间复杂度
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        
        int max = Integer.MIN_VALUE;
        int prod = 1;
       
        // 除了0或者负数，其他的相乘都不会变小
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            max = Math.max(max, prod);
            if (prod == 0)
                prod = 1;
        }
        
        prod = 1;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            prod *= nums[i];
            max = Math.max(max, prod);
            if (prod == 0)
                prod = 1;
        }
        
        return max;
    }

    /**
     * 基于动态规划的解法 
     * {dp}
     * 时间复杂度也是on，但是系数的计算更多
     */
    public int maxProduct2(int[] nums) {
        if(nums.length == 1)
             return nums[0];
         
        int min = nums[0];
        int max = nums[0];
         // 注意totalMax也需要初始化。
        int totalMax = Math.max(nums[0],Integer.MIN_VALUE);
        
        for(int i =1;i<nums.length;i++){
            
            int prevMin = min*nums[i];
            int prevMax = max*nums[i];
            
            min = Math.min(nums[i], Math.min(prevMin, prevMax));
            max = Math.max(nums[i], Math.max(prevMin, prevMax));
            totalMax = Math.max(totalMax, max);
        }
        return totalMax;
     }

}
