package leetcode.a1100;

import java.util.Arrays;
/**
 * 拆炸弹
 */
public class _1652Solution {

    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];

        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        } else if (k > 0) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 1; j <= k; j++) {

                    res[i] += code[(i + j % res.length) % res.length];
                }
            }
            return res;
        } else if (k < 0) {
            k = -k;
            for (int i = 0; i < res.length; i++) {
                for (int j = 1; j <= k; j++) {
                    // TODO 循环数组向左遍历要小心索引小于0的情况
                    res[i] += code[(res.length + i - j % res.length) % res.length];
                }
            }
            return res;
        }
        return res;
    }
}
