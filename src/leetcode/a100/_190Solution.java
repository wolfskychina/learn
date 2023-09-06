package leetcode.a100;

public class _190Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            rev |= (n & 1);
            n >>= 1;
        }
        return rev;
    }

    public static void main(String[] args){

        _190Solution so = new _190Solution();
        System.out.print(so.reverseBits(2147483647));

    }
}
