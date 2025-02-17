package leetcode.a2000;

/**
 * 将一个只含abc三种字符的字符串构造有效字符串的最少插入次数
 * 有效字符串指abcabcabc。。。形式
 * {greedy}
 */
public class _2645Solution {

    public int addMinimum(String word) {

        char[] w = word.toCharArray();

        int res = 0;
        int i = 0;
        while (i < w.length) {

            if (i < w.length - 2) {
                if (w[i] == 'a' && w[i + 1] == 'b' && w[i + 2] == 'c') {
                    i += 3;
                } else if (w[i] == 'a' && w[i + 1] == 'b') {
                    i += 2;
                    res++;
                } else if (w[i] == 'a' && w[i + 1] == 'c') {
                    i += 2;
                    res++;
                } else if (w[i] == 'a') {
                    i += 1;
                    res += 2;
                } else if (w[i] == 'b' && w[i + 1] == 'c') {
                    i += 2;
                    res++;
                } else if (w[i] == 'b') {
                    i += 1;
                    res += 2;
                } else {
                    i += 1;
                    res += 2;
                }
            } else if (i < w.length - 1) {
                if (w[i] == 'a' && w[i + 1] == 'b') {
                    i += 2;
                    res++;

                } else if (w[i] == 'a' && w[i + 1] == 'c') {
                    i += 2;
                    res++;
                } else if (w[i] == 'a') {
                    i += 1;
                    res += 2;
                } else if (w[i] == 'b' && w[i + 1] == 'c') {
                    i += 2;
                    res++;
                } else if (w[i] == 'b') {
                    i += 1;
                    res += 2;
                } else {
                    i += 1;
                    res += 2;
                }

            } else {
                i += 1;
                res += 2;
            }
        }

        return res;
    }

    /**
     * 考虑相邻字符，当在字符表中相邻的情况下不需要插入
     * 否则需要插入(s[i] + 2 - s[i - 1]) % 3个字符
     * @param word
     * @return
     */
    public int addMinimum1(String word) {
        char[] s = word.toCharArray();
        int ans = s[0] + 2 - s[s.length - 1];
        for (int i = 1; i < s.length; i++) {
            ans += (s[i] + 2 - s[i - 1]) % 3;
        }
        return ans;
    }

}
