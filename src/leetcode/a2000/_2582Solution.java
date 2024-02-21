package leetcode.a2000;
/**
 * 递枕头
 */
public class _2582Solution {
   
    /**
     * 编号从1开始需要额外小心处理
     * {mod}
     * @param n
     * @param time
     * @return
     */
    public int passThePillow(int n, int time) {
        int remain = time % (2*(n-1));
        if(remain<n) return 1+remain;
        return 2*(n-1)-remain +1;
    }
}
