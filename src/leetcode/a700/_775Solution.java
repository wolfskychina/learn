package leetcode.a700;
/**
 * 全局倒置pair数量和局部倒置pair数量是否一致
 */
public class _775Solution {
   
    /**
     * {permutation}, 局部倒置比为全局倒置
     * 所以只需要判断是否存在全局倒置但不是局部倒置的情况
     * @param nums
     * @return
     */
    public boolean isIdealPermutation(int[] nums) {
        int max = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < max) return false;
            max = Math.max(max, nums[i - 1]);
        }
        return true;
    }
}
