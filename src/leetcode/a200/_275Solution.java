package leetcode.a200;

/**
 * 引用H指数，给了升序的数组
 */
public class _275Solution {

    /**
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {

        int l = 0;
        // 注意这个r是开区间
        int length = citations.length;
        int r = length;
        // 因为r是开区间，所以是<而不是<=
        while (l < r) {
            int mid = l + (r - l) / 2;
            if ((length - mid) <= citations[mid]) {
                // 注意移动方向和降序排序完全相反
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        // 返回的是包括索引l的右侧的元素个数，而不是l本身
        return length - l;
    }

}