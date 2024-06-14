package leetcode.a400;

import java.util.Arrays;
import java.util.Random;

/**
 * 一个整数数组，每次可以对任意一个元素+1或者-1，求最少多少次操作后
 * 使得所有的元素相等
 */
public class _462Solution {

    /**
     * 将各个元素调整到中位数的时候，需要操作的总次数最少
     * 排序后，n/2的位置就是中位数
     * 
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ret = 0, x = nums[n / 2];
        for (int i = 0; i < n; i++) {
            ret += Math.abs(nums[i] - x);
        }
        return ret;
    }

    /**
     * 根据中位数的计算原理，可以不先计算中位数
     * 
     * @param nums
     * @return
     */
    public int minMoves3(int[] nums) {
        Arrays.sort(nums);
        int move = 0;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            move += nums[h] - nums[l];
            l++;
            h--;
        }
        return move;

    }

    Random random = new Random();

    /**
     * 使用快速选择算法找到排序后位置为n/2的元素就是中位数
     * 快速选择排序的时间复杂度是on
     * 
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int n = nums.length, x = quickSelect(nums, 0, n - 1, n / 2), ret = 0;
        for (int i = 0; i < n; ++i) {
            ret += Math.abs(nums[i] - x);
        }
        return ret;
    }

    public int quickSelect(int[] nums, int left, int right, int index) {
        int q = randomPartition(nums, left, right);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
        }
    }

    public int randomPartition(int[] nums, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(nums, i, right);
        return partition(nums, left, right);
    }

    public int partition(int[] nums, int left, int right) {
        int x = nums[right], i = left - 1;
        for (int j = left; j < right; ++j) {
            // =号保证了稳定性，保证和x相等的值在x的左边
            if (nums[j] <= x) {
                ++i;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
