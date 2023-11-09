package leetcode.a500;

/**
 * 一个数组，求最小长度的子数组，将该子数组排序即可使得整个数组有序
 * 更高要求 on的时间复杂度
 */
public class _581Solution {

    /**
     * {Inverse Pair},{greedy}
     * 向右找到第一个逆序对然后再从头找到需要【该逆序对中较小的值】所在的位置
     * 不一定是左边界，因为该逆序对中较小的值不一定是最小值,应该继续向右找到最小值，
     * 用最小值再从左边去找。右侧边界同理
     * on时间复杂度
     * 
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {

        int i = 0;
        while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
            i++;
        }
        if (i == nums.length - 1)
            return 0;
        int ii = 0;
        int min = Integer.MAX_VALUE;
        for (int l = i + 1; l < nums.length; l++) {
            min = Math.min(min, nums[l]);
        }
        while (ii < i && nums[ii] <= min) {
            ii++;
        }
        // ii is the left boundry;
        int j = nums.length - 1;
        while (nums[j] >= nums[j - 1])
            j--; // 16 12 15 17 18
        int max = Integer.MIN_VALUE;
        for (int r = j - 1; r >= 0; r--) {
            max = Math.max(max, nums[r]);
        }
        int jj = nums.length - 1;
        while (jj > j && nums[jj] >= max)
            jj--;
        // jj is the right boundry;
        return jj - ii + 1;

    }

    /**
     * 只需要1趟的解法
     * 原理，原数列可以分为a,b,c三段，其中a,c是有序的，b是需要重排序的
     * 对于a中的任意一个数，都小于bc中的任何一个数
     * 
     * @param nums
     * @return
     */
    public int findUnsortedSubarray1(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

}
