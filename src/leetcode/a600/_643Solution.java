package leetcode.a600;
/**
 * 长度为k的子数组中各元素的最大平均值
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
            if (curSum > maxSum) {
                maxSum = curSum;
            }

            l++;
            r++;
        }

        return maxSum / k;

    }
}
