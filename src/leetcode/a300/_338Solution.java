package leetcode.a300;

public class _338Solution {

    public int[] countBits(int n) {
        int[] res;
        if (n == 0) {

            res = new int[] { 0 };
            return res;
        }
        if (n == 1) {
            res = new int[] { 0, 1 };
            return res;
        }
        res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 1; i < n; i++) {
            // 每增1,只影响最右面连续1的个数
            res[i + 1] = res[i] - (int) (Math.log((i + 1) & (~i)) / Math.log(2)) + 1;
        }
        return res;

    }

    /**
     * 
     * @param n
     * @return
     */
     public int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    /**
     * n和n>>1的1的个数的关系仅相差最后一位是否为1
     * @param n
     * @return
     */
     public int[] countBits3(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }


    public static void main(String[] args){
        _338Solution so = new _338Solution();
        so.countBits(5);

    }
}
