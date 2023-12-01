package leetcode.a700;
/**
 * 判断区间内有多少个数，他们的二进制表示中1的个数是质数
 */
public class _762Solution {
  
    /**
     * {bitCount}
     * @param left
     * @param right
     * @return
     */
    public int countPrimeSetBits(int left, int right) {

        int bits [] = new int[20];
        for(int i=left;i<=right;i++){

            bits[Integer.bitCount(i)]++;
        }
        return  bits[2]+bits[3]+bits[5]+bits[7]+bits[11]+bits[13]+bits[17]+bits[19];

    }
}
