package leetcode.a400;
/**
 * 两个海明码的距离
 */
public class _461Solution {
   
    /**
     * 相邻海明码只有1位不同
     * 两个海明码的距离是两个编码中相同位的数不相等的位的数量和
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {

        int dis =0;
        int z = x^y;
        for(int i=0;i<32;i++){

            if((z&1)==1) dis++;
            z =z>>1;
        }
        return dis;
    }
}
