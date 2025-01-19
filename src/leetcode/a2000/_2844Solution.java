package leetcode.a2000;

/**
 * 生成特殊数字的最少操作
 * 删除若干字符使得剩下的位数组成的数字能被25整除
 * {math}
 */
public class _2844Solution {

    public int minimumOperations(String num) {

        char[] s = num.toCharArray();
        int res = s.length;
        res = Math.min(res, Math.min(find(s, '5', '0'), Math.min(find(s, '2', '5'), find(s, '0', '0'))));
        res = Math.min(res, find(s, '7', '5'));
        if (num.contains("0")) {
            res = Math.min(res, s.length - 1);
        }

        return res;
    }

    private int find(char[] s, char c1, char c2) {
        int i = s.length - 1;
        while (i >= 0) {
            if (s[i] == c2)
                break;
            i--;
        }
        if (i < 0 || s[i] != c2)
            return Integer.MAX_VALUE;
        i--;
        while (i >= 0) {
            if (s[i] == c1)
                break;
            i--;
        }
        if (i < 0 || s[i] != c1)
            return Integer.MAX_VALUE;
        return s.length - i - 2;

    }
}
