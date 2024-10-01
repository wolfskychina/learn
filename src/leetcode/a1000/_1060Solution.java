package leetcode.a1000;

/**
 * 已排序数组中从最左侧起始缺失的第k个数
 */
public class _1060Solution {

    /**
     * 构造缺失元素数量的数组，表示到从左侧到nums[i]元素的时候
     * 左面缺失的元素数目，然后用二分法查找
     * {binary search},{prefix sum}
     * 
     * @param nums
     * @param k
     * @return
     */
    public int missingElement(int[] nums, int k) {

        int miss[] = new int[nums.length];
        for (int i = 1; i < miss.length; i++) {
            miss[i] = miss[i - 1] + nums[i] - nums[i - 1] - 1;
        }
        int l = 0;
        int r = miss.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (miss[mid] < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[l - 1] + k - miss[l - 1];
    }
}
