package leetcode.a900;
/**
 * 环形数组中子数组的最大前缀和
 * 环形数组的子数组的最大长度不能超过环形数组的长度
 * 类似 53题
 */
public class _918Solution {

    /**
     * {prefix sum}使用前缀和超时了，on2的时间复杂度
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {

        int prefix[] = new int[2 * nums.length + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < prefix.length; i++) {

            prefix[i] = prefix[i - 1] + nums[(i - 1) % nums.length];
        }

        for (int i = 0; i <= nums.length; i++) {

            for (int j = i + 1, n = 0; n < nums.length; j++, n++) {

                max = Math.max(max, prefix[j] - prefix[i]);
            }
        }

        return max;

    }


    /**
     * 只遍历一趟的做法
     * {dp}根据循环数组的特征，如果最大子数组在[0,n)当中，那么最小数组可能被最大数组分割成两部分，
     * 然而在循环数组中，被分割成的两部分在循环数组中是相连的，因此也是子数组；
     * 类似的，如果最小子数组在[0,n)当中，那么最大数组可能被分开但是在循环数组中也是相连的；
     * 还有一种可能，最大子数组和最小子数组恰好没有互相分开，一个是[0,i),一个是[i,n)这种情况两个数组都在[0,n)中
     * 所以，只要同时统计【不】循环数组的最大子数组和最小子数组，就可以知道循环数组的最大和
     * @param A
     * @return
     */
    public int maxSubarraySumCircular1(int[] A) {
        int total = 0, maxSum = A[0], curMax = 0, minSum = A[0], curMin = 0;
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
    
}
