package leetcode.a800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 找出数组排序后的目标下标
 */
public class _2089Solution {

    public List<Integer> targetIndices(int[] nums, int target) {

        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 类似于基数排序
     * {counting sort}
     * @param nums
     * @param target
     * @return
     */
    public List<Integer> targetIndices1(int[] nums, int target) {
        int countLess = 0, countEqual = 0;
        for (int num : nums) {
            if (num < target) {
                countLess++;
            } else if (num == target) {
                countEqual++;
            }
        }
        List<Integer> indices = new ArrayList<Integer>();
        for (int i = 0; i < countEqual; i++) {
            indices.add(countLess + i);
        }
        return indices;
    }
}
