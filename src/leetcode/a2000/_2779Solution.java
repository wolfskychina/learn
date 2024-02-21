package leetcode.a2000;

import java.util.Arrays;

/**
 * 数组的最大Beauty值
 * 有若干长度相同的整数区间，知道其中点，求最大的有共同重叠区间的数量
 */
public class _2779Solution {
   
    /**
     * 累计每个x坐标被包含到的区间的数量
     * on2的时间复杂度，超时了
     * @param nums
     * @param k
     * @return
     */
    public int maximumBeauty(int[] nums, int k) {

        int[] count = new int[100001];

        for(int i:nums){

            count[i]++;
            for(int j=1;j<=k;j++){
                if(i+j<=100000) count[i+j]++;
                if(i-j>=0 )count[i-j]++;
            }
        }

        int max=0;
        for(int i:count){
            max = Math.max(max,i);
        }

        return max;
    }

    /**
     * 所有有重叠的区间，在排序后必然是相邻的
     * 而且中点最大值和最小值的差不能超过2k，否则无法通过调整到一点上
     * {sliding window}
     * @param nums
     * @param k
     * @return
     */
    public int maximumBeauty1(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;
        for (int l = 0, r = 0; r < n; r++) {

            while (nums[r] > nums[l] + 2 * k) l++;
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
