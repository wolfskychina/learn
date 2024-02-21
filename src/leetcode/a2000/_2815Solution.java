package leetcode.a2000;

import java.util.Arrays;
/**
 * 数组中的任意最大数位值相同的数的和的最大值
 * 只需要一次遍历
 */
public class _2815Solution {
   
    public int maxSum(int[] nums) {
        int ans = -1;
        var maxVal = new int[10];
        Arrays.fill(maxVal, Integer.MIN_VALUE);
        for (int v : nums) {
            int maxD = 0;
            for (int x = v; x > 0; x /= 10)
                maxD = Math.max(maxD, x % 10);
            ans = Math.max(ans, v + maxVal[maxD]);
            maxVal[maxD] = Math.max(maxVal[maxD], v);
        }
        return ans;
    }

}
