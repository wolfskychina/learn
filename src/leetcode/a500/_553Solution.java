package leetcode.a500;
/**
 * 除法最优加括号方式
 * 使得最终的表达式结果最大
 */
public class _553Solution {
   
    /**
     * {greedy}
     * @param nums
     * @return
     */
    public String optimalDivision(int[] nums) {

        if(nums.length==1) return String.valueOf(nums[0])
;
        if(nums.length ==2) return ""+String.valueOf(nums[0])+"/"+String.valueOf(nums[1]);
        
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/").append("(");
        for(int i=1;i<nums.length;i++){

            sb.append(nums[i]).append("/");
        }
        sb.setLength(sb.length()-1);
        sb.append(")");
        return sb.toString();
    }
}
