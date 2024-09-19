package leetcode.a1000;

/**
 * Minimum Flips to Make a OR b Equal to c
 * 使得两个数做或运算的结果等于c的最少翻转位数
 * {bit manuplation}
 */
public class _1318Solution {

    public int minFlips(int a, int b, int c) {

        int num = 0;
        int max = Math.max(a, Math.max(b, c));
        while (max != 0) {
            int aa = a & 1;
            int bb = b & 1;
            int cc = c & 1;

            if ((aa | bb) != cc) {
                if (cc == 1) {
                    num++;

                } else {
                    if (aa == 1 && bb == 1)
                        num += 2;
                    else
                        num++;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
            max >>= 1;
            // 1000
            // 0010
            // 0101
        }

        return num;
    }
}
