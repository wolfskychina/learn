package leetcode.array;

// Number of 1 Bits
public class _191Solution {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum =0 ;
        for(int i=0;i<32;i++){

            sum += n & 1;
            n = n>>1;
        }

        return sum;
    }
}
