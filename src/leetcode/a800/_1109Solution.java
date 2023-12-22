package leetcode.a800;
/**
 * 航班预订统计
 */
public class _1109Solution {
    
    /**
     * {prefix sum},{Difference array}差分数组和前缀数组的转换关系
     * 对于区间相同的增量，差分数组只需要修改两处地方
     * TODO 
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
