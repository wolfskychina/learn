package leetcode.a800;

import java.util.ArrayList;
import java.util.List;
/**
 * 合并两个二维数组
 * {easy}
 */
public class _2570Solution {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i1 = 0;
        int i2 = 0;
        List<int[]> list = new ArrayList<>();

        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1][0] < nums2[i2][0]) {
                list.add(nums1[i1++]);
            } else if (nums1[i1][0] > nums2[i2][0]) {
                list.add(nums2[i2++]);
            } else {
                list.add(new int[] { nums1[i1][0], nums1[i1][1] + nums2[i2][1] });
                i1++;
                i2++;
            }
        }
        while (i1 < nums1.length) {
            list.add(nums1[i1++]);
        }
        while (i2 < nums2.length) {
            list.add(nums2[i2++]);
        }

        return list.toArray(new int[list.size()][]);
    }
}
