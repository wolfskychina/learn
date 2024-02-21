package leetcode.a1000;
/**
 * 将一个数组的数字异或
 * {xor}
 */
public class _1486Solution {
   
    public int xorOperation(int n, int start) {

        int re = start;
        for(int i=1;i<n;i++){
            int tmp = start+2*i;
            re = re^tmp;
        }
        return re;
    }
}
