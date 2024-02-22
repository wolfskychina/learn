package leetcode.a2000;
/**
 * 从start转换成goal所需要的最少转换次数
 * {easy}
 * {bit manuplating}
 */
public class _2220Solution {
   
    public int minBitFlips(int start, int goal) {

        int xor = start^goal;
        int count=0;
        while(xor!=0){
            count+= xor&1;
            xor = xor>>1;
        }
        return count;
    }
}
