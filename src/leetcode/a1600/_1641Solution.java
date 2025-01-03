package leetcode.a1600;

import java.util.Arrays;

/**
 * 统计字典序元音字符串的数目,字符串内的字符必须是升序排列的
 * {dp}
 */
public class _1641Solution {

    /**
     * 考虑长度的增长，以每一个元音字符结尾的长度为i的元音字符的可能性
     * @param n
     * @return
     */
    public int countVowelStrings(int n) {

        int f[][] = new int[51][5];
        Arrays.fill(f[1], 1);
        for (int i = 2; i <= n; i++) {
            f[i][0] = f[i - 1][0];
            f[i][1] = f[i - 1][0] + f[i - 1][1];
            f[i][2] = f[i - 1][0] + f[i - 1][1] + f[i - 1][2];
            f[i][3] = f[i - 1][0] + f[i - 1][1] + f[i - 1][2] + f[i - 1][3];
            f[i][4] = f[i - 1][0] + f[i - 1][1] + f[i - 1][2] + f[i - 1][3] + f[i - 1][4];
        }

        return f[n][0] + f[n][1] + f[n][2] + f[n][3] + f[n][4];
    }
}
