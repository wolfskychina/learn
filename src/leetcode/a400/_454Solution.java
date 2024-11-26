package leetcode.a400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 四个相同长度的数组，每个数组任取一个值，和是0的组合方式共有多少种
 */
public class _454Solution {

    /**
     * 空间换时间，两个一组计算，结果存hashmap里面对比
     * 
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for (int u : A) {
            for (int v : B) {
                // countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
                countAB.merge(u + v, 1, (a, b) -> a + b);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;
    }

    /**
     * 优化方法，数组排序，这样遇到相同的数，可以只计算一次
     * 
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);

        int resultCounter = 0;
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            int iStart = i;
            // 重复就加快循环
            while (i + 1 < nums1.length && nums1[i] == nums1[i + 1]) {
                i++;
            }

            for (int j = 0; j < nums2.length; j++) {
                int jStart = j;
                while (j + 1 < nums2.length && nums2[j] == nums2[j + 1]) {
                    j++;
                }
                numMap.put(nums1[i] + nums2[j],
                        numMap.getOrDefault(nums1[i] + nums2[j], 0) + (i - iStart + 1) * (j - jStart + 1));
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            int iStart = i;
            while (i + 1 < nums3.length && nums3[i] == nums3[i + 1]) {
                i++;
            }
            for (int j = 0; j < nums4.length; j++) {
                int jStart = j;
                while (j + 1 < nums4.length && nums4[j] == nums4[j + 1]) {
                    j++;
                }
                resultCounter += numMap.getOrDefault(-nums3[i] - nums4[j], 0) * (i - iStart + 1) * (j - jStart + 1);
            }
        }
        return resultCounter;
    }
}
