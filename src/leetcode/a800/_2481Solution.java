package leetcode.a800;
/**
 * 将圆分成n等分的最少切割次数
 * {easy}
 */
public class _2481Solution {
   
    public int numberOfCuts(int n) {

        if(n==1) return 0;
        if(n%2==0)
            return n/2;
        return n;
    }
}
