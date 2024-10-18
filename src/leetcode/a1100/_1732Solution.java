package leetcode.a1100;
/**
 * 最高海拔
 * {easy}
 */
public class _1732Solution {
   
    public int largestAltitude(int[] gain) {

        int max = 0;
        int cur = 0;
        for(int i=0;i<gain.length;i++){
            cur += gain[i];
            max = Math.max(max,cur);
        }
        return max;
    }
}
