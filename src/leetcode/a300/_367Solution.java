package leetcode.a300;
/**
 * 判断一个数是不是完全平方数
 */
public class _367Solution {

    /**
     * 二分法快速定位
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {

        long tar = (long) num;
        int l = 0;
        int r = num / 2 + 1;
        while (l < r) {
            int mid = (l + r) / 2;
            // 注意这个地方整数强制转换之后再计算
            if ((long)mid *mid < tar) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r * r == tar;
    }

    public static void main(String[] args){
        _367Solution so = new _367Solution();
        so.isPerfectSquare(808201);
    }
}
