package leetcode.a2000;

import java.util.ArrayList;
import java.util.List;

/**
 * 将元素分配到两个数组中
 * {easy}
 */
public class _3069Solution {

    public int[] resultArray(int[] nums) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(nums[0]);
        list2.add(nums[1]);

        for (int i = 2; i < nums.length; i++) {

            if (list1.get(list1.size() - 1) > list2.get(list2.size() - 1)) {

                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }

        int[] res = new int[list1.size() + list2.size()];
        int i = 0;
        for (int n : list1) {
            res[i++] = n;
        }
        for (int n : list2) {
            res[i++] = n;
        }
        return res;
    }

    /**
     * 使用一个数组分别从正反两个方向存储，不使用额外的存储空间
     */
    public int[] resultArray1(int[] nums) {
        int[] result = new int[nums.length];
        int index1 = 0;
        int index2 = nums.length - 1;
        result[index1] = nums[0];
        result[index2] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (result[index1] > result[index2]) {
                result[++index1] = nums[i];
            } else {
                result[--index2] = nums[i];
            }
        }
        int temp = 0;
        for (int i = index2, j = nums.length - 1; i < j; i++, j--) {
            temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }
        return result;
    }
}
