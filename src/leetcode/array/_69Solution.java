package leetcode.array;

public class _69Solution {

    public int mySqrt(int x) {
        if (x == 0 || x==1)
            return x;

        int left = 1, right = x/2+1;

        while (left<right) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid;
            } else{
                left = mid+1;
            }
        }

        return left-1;
    }

    public static void main(String[] args){

        _69Solution so = new _69Solution();
        for(int i=0;i<70;i++){
            System.out.println("Sqrt "+i+" is :"+so.mySqrt(i));
        }
    }
}
