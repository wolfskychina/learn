package leetcode.a300;

/**
 * 简单的猜数字大小
 */
public class _374Solution {

    //  二分查找
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == 1) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        return l;

    }

    private int guess(int mid) {
        return 0;
    }
}
