package leetcode.a1700;

/**
 * 通过最少操作次数使两个数组元素之和相等
 * 两个数组元素数量不一定相等
 * 每个元素的取值范围为1-6
 */
public class _1775Solution {

    /**
     * 先根据两个数组的元素个数判断能否通过修改使和一致
     * 然后根据各自和的大小之差，优先调整能够一次缩小最大更大值的元素
     * {greedy}
     * @param nums1
     * @param nums2
     * @return
     */
    public int minOperations1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 > len2 && len1 > 6 * len2) {
            return -1;
        }
        if (len2 > len1 && len2 > 6 * len1) {
            return -1;
        }

        int sum1 = 0;
        int sum2 = 0;
        int add1[] = new int[6];
        int add2[] = new int[6];
        int min1[] = new int[6];
        int min2[] = new int[6];
        for (int i : nums1) {
            sum1 += i;
            add1[6 - i]++;
            min1[i - 1]++;
        }
        for (int i : nums2) {
            sum2 += i;
            add2[6 - i]++;
            min2[i - 1]++;
        }
        if (sum1 == sum2)
            return 0;
        if (sum1 > sum2)
            return findMinOps(sum1 - sum2, min1, add2);
        return findMinOps(sum2 - sum1, min2, add1);

    }

    private int findMinOps(int sum, int[] min, int[] add) {
        int step = 0;
        for (int i = 5; i > 0; i--) {

            for (int j = min[i]; j > 0; j--) {
                sum -= i;
                step++;
                if (sum <= 0)
                    return step;
            }
            for (int j = add[i]; j > 0; j--) {
                sum -= i;
                step++;
                if (sum <= 0)
                    return step;
            }
        }

        return -1;
    }

    /**
     * 优化的解法，速度更快
     * @param nums1
     * @param nums2
     * @return
     */
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length * 6 < nums2.length || nums2.length * 6 < nums1.length) {
            return -1;
        }
        // 求差值
        int d = 0;
        for (int i : nums1) {
            d += i;
        }
        for (int i : nums2) {
            d -= i;
        }
        // 确定最大数组
        if (d < 0) {
            d = -d;
            int[] tmp = nums2;
            nums2 = nums1;
            nums1 = tmp;
        }

        int[] cnt = new int[6];
        for (int x : nums2)
            cnt[6 - x]++;
        for (int x : nums1)
            cnt[x - 1]++;
        for (int i = 5, ans = 0;; --i) {
            // 优化
            // 对于能够改变同样大小的元素，一次直接计算所有元素的和
            if (i * cnt[i] >= d)
                // 向上取整
                return ans + (d + i - 1) / i;
            ans += cnt[i];
            d -= i * cnt[i];
        }
    }
}
