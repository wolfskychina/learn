package leetcode.a700;
/**
 * 未知长度的有序数组中寻找特定的数字
 */
public class _702Solution {

    /**
     * {binary search}
     * @param reader
     * @param target
     * @return
     */
    public int search(ArrayReader reader, int target) {

        int l = 0;
        int r = 10000;
        while (l < r) {
            int mid = (l + r) / 2;
            int midval = reader.get(mid);
            if (midval >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return reader.get(l) == target ? l : -1;

    }

    interface ArrayReader {
        public int get(int index);
    }
}
