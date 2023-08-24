package leetcode.a300;

/**
 * 寻找数组中的最短子数组，使得子数组的和大于等于s
 * 双指针
 * 开始没看仔细，子数组是连续的区间，所以可以用双指针
 */
public class _209Solution {
   
    public int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
          return 0;
        
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        
        while (j < a.length) {
          sum += a[j++];
          
          while (sum >= s) {
            min = Math.min(min, j - i);
            sum -= a[i++];
          }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
      }
}
