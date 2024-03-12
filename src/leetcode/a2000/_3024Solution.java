package leetcode.a2000;
/**
 * 判断三角形的类型
 * {easy}
 */
public class _3024Solution {
   
    public String triangleType(int[] nums) {

        if((nums[0] + nums[1])<=nums[2] || (nums[1]+nums[2])<=nums[0] || (nums[0]+nums[2])<=nums[1])
            return "none";
        if(nums[0]==nums[1]&&nums[1]==nums[2])
            return "equilateral";
        if(nums[0]==nums[1]||nums[0]==nums[2]||nums[1]==nums[2])
            return "isosceles";
        return "scalene";
    }
}
