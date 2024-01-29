package leetcode.a800;
/**
 * 二进制表示中两个1之间的最大连续0的间距
 * {easy}
 */
public class _868Solution {
   
    public int binaryGap(int n) {

        while (n != 0 && n % 2 != 1) {
            n = n >> 1;
        }
        if (n == 0)
            return 0;
        int max = 0;
        while (n != 0) {
            int count = 1;
            n = n >> 1;
            while (n != 0 && n % 2 == 0) {
                n = n >> 1;
                count++;
            }
            if (n == 0)
                return max;
            max = Math.max(max,count);
        }

        return max;
    }

    public static void main(String[] args){
        _868Solution so = new _868Solution();
        so.binaryGap(22);
    }
}
