package leetcode.a1000;

import java.util.Arrays;
/**
 * 小于k并且最接近的的两数之和
 */
public class _1099Solution {

    /**
     * 自己想的二分查找，需要n2的额外空间
     * 比较慢
     * {binary search}
     * @param nums
     * @param k
     * @return
     */
    public int twoSumLessThanK(int[] nums, int k) {

        int sum[] = new int[nums.length * (nums.length - 1) / 2];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum[idx++] = nums[i] + nums[j];
            }
        }
        Arrays.sort(sum);
        int l = 0;
        int r = sum.length - 1;
        while (l < r) {

            int mid = (l + r) / 2;
            if (sum[mid] >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (l==0)
            return -1;
        return sum[l-1];
    }

    /**
     * {two pointers}
     * 双指针，on复杂度
     * @param nums
     * @param k
     * @return
     */
    public int twoSumLessThanK1(int[] nums, int k) {
        Arrays.sort(nums);
        int answer = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                answer = Math.max(answer, sum);
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }


    public static void main(String[] args){

        _1099Solution so = new _1099Solution();
        int [] nums = {34,23,1,24,75,33,54,8};
        so.twoSumLessThanK(nums, 60);
    }
}
