package leetcode.a3000;

import java.util.Arrays;

/**
 * 查询数组中元素出现的位置
 * {index}
 * 注意索引的转换关系
 */
public class _3159Solution {

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {

        int idx[] = new int[nums.length];
        Arrays.fill(idx, -1);
        int i = 0;
        for (int j = 0; j < nums.length; j++) {

            if (nums[j] == x) {
                idx[i++] = j;
            }
        }
        int res[] = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            // 需要加判断防止越界到idx之外
            res[j] = queries[j] - 1 >= idx.length ? -1 : idx[queries[j] - 1];
        }
        return res;
    }
}
