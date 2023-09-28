package leetcode.a300;

public class _367Solution {

    public boolean isPerfectSquare(int num) {

        long tar = (long) num;
        int l = 0;
        int r = num / 2 + 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (((long)mid *(long)mid) < tar) {
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
