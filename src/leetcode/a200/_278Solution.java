package leetcode.a200;

/**
 * 寻找第一个出错的版本号
 * {binary search}
 */
public class _278Solution {

    /**
     * 如果n是Integer.MAX_VALUE,用n+1作为右侧的界会溢出
     * 所以将[1,n+1)的区间映射为[0,n)的区间，那么在索引值为mid时
     * 对应的版本号其实是mid+1，其他的索引和版本号的对应值相同
     * 最后返回l+1
     * 
     * @param n
     * @return
     */
    public int firstBadVersion2(int n) {

        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid + 1)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        // 这个前提条件是一定存在badversion，否则还要
        // 判断l是不是badversion
        return l + 1;

    }

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
