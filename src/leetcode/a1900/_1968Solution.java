package leetcode.a1900;

import java.util.Arrays;

/**
 * 构造元素不等于两相邻元素平均值的数组
 * nums中的所有元素均不相同
 */
public class _1968Solution {

    /**
     * {greedy},{sort}
     * 排序之后，前半部分选两个数，他们的平均值肯定小于后半部分选出的任何数
     * 同样，后半部分选两个数，他们的平均值肯定大于前半部分选出的任何数
     * 所以，只需要将前半部分和后半部分的数交替出现即可
     * @param nums
     * @return
     */
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int r = n - 1;
        int l = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                res[i] = nums[r];
                r--;
            } else {
                res[i] = nums[l];
                l++;
            }
        }
        return res;
    }
}
