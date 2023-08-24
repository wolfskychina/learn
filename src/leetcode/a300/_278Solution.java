package leetcode.a300;

/**
 * 寻找第一个出错的版本号
 */
public class _278Solution {

    /**
     * 二分查找
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {

        int l = 1;
        int r = n;// 这个地方使用了闭区间
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;

    }

    private boolean isBadVersion(int mid) {

        return true;
    }
}
