package leetcode.a600;
/**
 * 长度为k的子数组中各元素的最大平均值
 * {match},{two pointers}
 */
public class _643Solution {

    public double findMaxAverage(int[] nums, int k) {

        int l = 0;
        int r = k;
        double maxSum = 0;
        double curSum = 0;

        for(int i=0;i<k;i++){
            maxSum += nums[i];
        }
        curSum = maxSum;

        while (r < nums.length) {

            curSum += nums[r]-nums[l];
            // 如果新元素使得和更大，就用新的元素替换
            // 子数组的和就替换成最新的和
            if (curSum > maxSum) {
                maxSum = curSum;
            }

            l++;
            r++;
        }

        return maxSum / k;

    }
}
