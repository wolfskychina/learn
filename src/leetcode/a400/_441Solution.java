package leetcode.a400;

public class _441Solution {
   
    public int arrangeCoins(int n) {

        int l=1;
        int r= (int)Math.sqrt(2.0*n)+1;

        while(l<r){
            int mid = (l+r)/2;
            int tmp = mid*(mid+1)/2;
            if(tmp>n){
                r = mid;
            }else{
                l = mid+1;
            }
        }

        return l-1;
    }
}
