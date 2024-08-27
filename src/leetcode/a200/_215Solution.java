package leetcode.a200;

/**
 * 寻找第k大的数
 * 快排里面的分划方法
 * {qsort}
 */
public class _215Solution {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        // [lo,hi]为闭区间
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {
        int i = lo;
        // j = hi+1 是为了正确处理只有两个元素的情况
        int j = hi + 1;
        while (true) {
            while (i < hi && less(a[++i], a[lo]))
                ;
            while (j > lo && less(a[lo], a[--j]))
                ;
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }
}
