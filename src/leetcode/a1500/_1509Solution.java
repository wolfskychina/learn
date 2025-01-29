package leetcode.a1500;

/**
 * 最多可以删除数组中的三个元素后，数组剩余元素的最大值和最小值的
 * 差值的最小值是多少
 * {greedy}
 */
public class _1509Solution {

    /**
     * 只需要知道最小的4个数和最大的4个数即可
     * on时间复杂度 
     * @param nums
     * @return
     */
    public int minDifference(int[] nums) {

        if (nums.length < 5)
            return 0;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int min4 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int max4 = Integer.MIN_VALUE;

        for (int i : nums) {

            if (i < min1) {

                min4 = min3;
                min3 = min2;
                min2 = min1;
                min1 = i;
            } else if (i < min2) {
                min4 = min3;
                min3 = min2;
                min2 = i;
            } else if (i < min3) {
                min4 = min3;
                min3 = i;
            } else if (i < min4) {
                min4 = i;
            }

            if (i > max1) {
                max4 = max3;
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) {
                max4 = max3;
                max3 = max2;
                max2 = i;
            } else if (i > max3) {
                max4 = max3;
                max3 = i;
            } else if (i > max4) {
                max4 = i;
            }
        }
        // 0,1,5,10,14
        return Math.min(Math.min(max1 - min4, max2 - min3), Math.min(max3 - min2, max4 - min1));
    }
}
