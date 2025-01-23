package leetcode.a1800;

import java.util.Arrays;

/**
 * 对原数组做以下操作
 * 新数组最小值为1
 * 可以任意调换元素的位置
 * 可以将任意元素变成更小的正整数
 * 新数组任意相邻元素的差值不能大于1
 * 问新数组中元素的最大值可能是多少？
 * {math},{greedy}
 */
public class _1846Solution {

    /**
     * 只能从1开始依次变大
     * @param arr
     * @return
     */
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        Arrays.sort(arr);
        int cur = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > cur)
                cur++;
        }
        return cur;
    }
}
