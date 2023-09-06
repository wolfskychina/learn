package leetcode.a200;

import java.util.Arrays;
/**
 * 一个数组中所有三个元素之和小于target的元组的个数
 */
public class _259Solution {
    int count;
    /**
     * on2算法的关键之处是以i作为元组中间的元素遍历数组
     * 这样前后的元素就相当于i的左右子树
     * 根据大小的差能够直接计算出以i为元组中间元素的符合
     * 条件的元组的个数
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        count = 0;
        Arrays.sort(nums);
        int len = nums.length;
    
        for(int i=0; i<len-2; i++) {
            int left = i+1, right = len-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    count += right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return count;
    } 
}
