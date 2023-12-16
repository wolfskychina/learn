package leetcode.a800;
/**
 * 找出中枢整数
 * {easy}
 */
public class _2485Solution {
   
    /**
     * {math} 等差数列求和公式
     * @param n
     * @return
     */
    public int pivotInteger(int n) {
        int x = (int)Math.sqrt(n*(n+1)/2);
        return x*x*2 == n*(n+1)?x:-1;
    }
}
