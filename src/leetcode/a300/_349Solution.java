package leetcode.a300;

import java.util.ArrayList;
import java.util.List;
/**
 * 两个数组的交集，数组里面可能有重复数据
 */
public class _349Solution {

    /**
     * 因为最大的数只有1000，所以可以用bit数组
     * 模拟的bit数组，但是占用更多没有必要的空间
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        boolean[] sum1 = new boolean[1001];
        boolean[] sum2 = new boolean[1001];

        for (int i : nums1) {
            sum1[i] = true;
        }
        for (int i : nums2) {
            sum2[i] = true;
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < sum1.length; i++) {
            if (sum1[i] & sum2[i]) {
                list.add(i);
            }

        }

        int res[] = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;

    }
}
