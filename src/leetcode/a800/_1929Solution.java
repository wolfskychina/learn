package leetcode.a800;
/**
 * 数组串联
 * {easy}
 */
public class _1929Solution {
   
    public int[] getConcatenation(int[] nums) {

        int res [] = new int[nums.length*2];
        for(int i=0;i<nums.length;i++){
            res[i] = nums[i];
            res[i+nums.length] =nums[i];
        }
        return res;
    }
}
