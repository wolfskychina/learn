package leetcode.a400;
/**
 * n个硬币堆台阶，每层硬币数比上层多一个
 * 问最多能堆多少层完整的
 * TODO 虽然是easy，但是调了很久
 */
public class _441Solution {
   
    /**
     * 二分搜索 
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {       


        int l=1;
        int r= (int)Math.sqrt(2.0*n)+2;

        while(l<r){
            int mid = l+(r-l)/2;
            // 这个地方注意溢出
            long tmp = (long)(mid)*(long)(mid+1)/2;
            if(tmp>n){
                r = mid;
            }else if(tmp<n){
                l = mid+1;
            }else{
                return mid;
            }
        }
        return l-1;
    }

    public static void main(String[] args){
        _441Solution so = new _441Solution();
        so.arrangeCoins(8);
    }
}
