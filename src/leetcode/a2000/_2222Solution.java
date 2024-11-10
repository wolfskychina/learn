package leetcode.a2000;

/**
 * 二进制串中010和101的子序列数
 * {dp}
 */
public class _2222Solution {

    public long numberOfWays(String s) {
        // 0,1,01,10,101,010
        char[] ss = s.toCharArray();
        long f1 = 0;// 0
        long f2 = 0;// 1
        long f3 = 0;// 01
        long f4 = 0;// 10
        long f5 = 0;// 101
        long f6 = 0;// 010

        for (int i = 0; i < ss.length; i++) {

            if (ss[i] == '0') {
                f1++;
                f4 += f2;
                f6 += f3;
            } else {
                f2++;
                f3 += f1;
                f5 += f4;
            }
        }

        return f5 + f6;
    }
}
